# puzzle-service-template

# Architectural decisions
We are using architecture decision records (ADR) to capture important architectural decisions.  
Records are stored under `doc/architecture/decisions`.  
There is an example of ADR to follow similar structure for further ADRs.

# Default libraries:
- log4j2  
  - logging
- junit5
  - unit testing framework
- assertj
  - assertion library
- archunit
  - unit testing framework for architecture testing
- mockito  
  - mocking framework  
  
# Configuration
- Line endings: `git config core.autocrlf input`
- Rename a package from `com.signavio.template` to `com.signavio._your_service_topic_`


# Important versions
Gradle `6.2`  

# Notes about packages
Each adapter has at least following packages:
- objects dedicated to communicate to underlying technology
    - **dto**
        - Data Transfer Objects which are responsible to communicate with underlying adapter technology. 
            - e.g. dto for REST communication, for storage persistence  
    - **message**  
        - Transfer objects which deal with event based systems
            - e.g. message for message queuing             
- **mapper**
    - Dedicated implementation of mapper which maps entity/event from core
    to adapter specific dto/message
    
 # Testing pyramid
 - Api
    - tests using HTTP requests against deployed app 
 - Contract
    - tests for REST endpoints contracts between different apps (see [LINK](https://confluence.signavio.com/display/ENG/Consumer+Driven+Contract+Testing))
 - Integration
    - tests of adapters (in clean arch POV). Certain aspects may be mocked for simplification.
 - Architecture
    - tests to verify architecture agreements, layering of code
 - Unit
    - unit tests of classes
 
 # Known issues
- Technically ArchUnit cannot check lombok existence due to lombok compile time nature
- Some weird problem with Android SDK sync [LINK](https://youtrack.jetbrains.com/issue/IDEA-209268)

# Open questions:
 - what is an alternative naming for persistence dto classes (something instead of *Info) 
 - Signavio id (standard for whole SPM? create a port for this id)  
 - How to be able to create tests in different configurations (api, contract, integ)
 