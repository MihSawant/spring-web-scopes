# spring-web-scopes
In this project we can observe and see the behaviour of the Login App in different scenarios of Web-Scopes:
  1. Request-Scope: Instantiate the Bean on per-request basis, which means that every time we make a new request then Spring
                    will create a new bean for that specific request, and the life-time of the bean is only until request is alive.
                    And this approach prevents the multiple data access and multithreading problem as we are not mutating the data through
                    multiple requests.
                    
                    
  2. Session-Scope: In this approach, Spring will create and instantiate the bean and store it for per session, which means if User A
                    has logged in then in the Spring Context it will create a new bean for User A and store it and let us assume that
                    A logged in again with-in the Session Lifetime then the same bean will be used which was created by the context earlier.
                    So here the bean is stored for a particular Session time Period. After the <i>session-period expires</i> then again on
                    login it will create a new session. It is useful so that we can store some user data on the session and reterive it 
                    when required in some part of application.
                    We again have to make sure that we are not adding too-much data into the session and also avoid storing the sensitive details.
                    As data is shared by multiple - requests then <em>Race Conditions</em> problems can occur. Also before adding the data into
                    the session we have to think twice because if you see in the application then LogingSessionManagement Service is dependent on
                    the LogingProcessor and they make our app more dependent so if instead we use database to store data then our requests can be 
                    independent of one-other.
                    
                    
  3. Application-Scope: This approach is exactly similar to the Singleton bean approach, but only thing is that we can only create one instance type of the 
                        bean in the context, and for every request we use the same instance in the context, Let us assume that we have Users A, B and C
                        then three of the user request's are using comman instance of the ApplicationScope bean, If you see in the example then ther is 
                        the LoginCountService which count's total no.of login-page request's.
                        Avoid this approach as much as possible because we are directly mutating the data through multiple requests and for concurrent 
                        applications, this may not be a good option.
