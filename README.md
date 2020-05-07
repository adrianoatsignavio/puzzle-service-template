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
  
# Git configuration
Line endings: `git config core.autocrlf input`

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