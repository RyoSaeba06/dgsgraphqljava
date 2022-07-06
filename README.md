# Secured Graphql Exploration
## Presentation
With this project, I wanted to explore the Netflix's graphql framework [DGS](https://netflix.github.io) and 
on top of that how to secure with OAuth2 and a Role Based Access Control (RBAC).

We will use [Keycloak](https://www.keycloak.org/) to secure the API and the API will be set as a [OAuth2 resource 
server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html).
### Use Case
I want to have a part of information secured:
* 1 data fetcher for Common User Info, which is public.
* 1 data fetcher (and loader) for HR Info, which is secured.

## Prerequisites
* You need to have [Docker](https://www.docker.com/get-started/) (docker-compose) installed.

## The Code
### Dependencies:

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server'
        implementation 'org.springframework.boot:spring-boot-starter-web'
    //	DGS
        implementation(platform('com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:latest.release'))
        implementation 'com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter'
    //	Faker
        implementation 'net.datafaker:datafaker:1.4.0'
    //	Lombok
        compileOnly 'org.projectlombok:lombok:1.18.24'
        annotationProcessor 'org.projectlombok:lombok:1.18.24'
        testCompileOnly 'org.projectlombok:lombok:1.18.24'
        testAnnotationProcessor 'org.projectlombok:lombok:1.18.24'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }
> I use **[Faker](https://www.datafaker.net/documentation/getting-started/)** to generate some datas 

### Spring Security Configuration
#### application.yml
    spring:
        security:
            oauth2:
                resourceserver:
                    jwt:
                        issuer-uri: http://localhost:8081/realms/demo
                        jwk-set-uri: http://localhost:8081/realms/demo/protocol/openid-connect/certs
So this is a basic configuration for an OAuth2 resource server.
#### Class SecurityConfiguration

    @EnableGlobalMethodSecurity(
            prePostEnabled = true,
            securedEnabled = true)

To activate **@Secured** we set the **securedEnabled** property.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(
                        authorize -> authorize.mvcMatchers("/rest/**").authenticated()
                                .anyRequest().permitAll())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(myConverter())
                        ));
        return http.build();
    }
I've also created a REST Controller in order to check my JWT : <mark>/rest/test</mark> is the only secured path.

**myConverter**: Because of RBAC and also because I don't use the Keycloak Configuration
, I've created a JWT converter that add the roles as authorities. 

> Of course, the best practice is to use the adapter provide by Keycloak, that will do the job for you.

## Keycloak 
### Run Keycloak
To run keycloak, go in the project directory and run : 
`docker-compose up`
![docker](/readme/dockerg.gif)
### Configure Keycloak
* Go to http://localhost:8081, and click on Admin console
* Enter username and password: **admin**
* You should be logged as admin, in the master realm
#### Import demo realm settings

![New Realm](/readme/keycloak.gif)

* Create new real, and import file : realm-export.json
* The Demo real is now created
* graphqlapi client created 

![grahqlclient](/readme/client.png)
* roles USER_ADMIN and USER_VIEWER are created

![grahqlclient](/readme/roles.png)

#### Create 2 users

![User creation](/readme/user.gif)

* Users > Add User
* Set the username
* Set the password
* Add a different role for each user (ex: superman is USER_ADMIN, batman is USER-VIEWER)

## Run and test
 * Start the app. you can do `./gradlew bootRun`
 * Once the app is started. Go to : http://localhost:8080/graphiql
 * Test the public access

![grahql test](/readme/graphiql.gif)

 Try with : 


    {
        users {
            id
            firstName
            lastName
            details {
                salary
            }
        }
    }

 * you should get : 

![permission denied](/readme/denied.png)

  Permission is handled by the **@Secured** annotation in the HRInfoDataFetcher class:


    @Secured("ROLE_USER_VIEWER")
    @DgsData(parentType = DgsConstants.USER.TYPE_NAME)
    public CompletableFuture<HRInfo> details(DgsDataFetchingEnvironment dfe) 

To access datas first you need to get the access token. 
> :bulb: You can use the postman collection file in main folder : Keycloak.getToken.json

Copy the access_token and set the Authorization header.

![Et Voila](/readme/secured.gif)

## Next (Maybe)
 * Mutation, Directive, Subscription