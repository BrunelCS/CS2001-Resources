# **Project Progress 2**

### Group number
20
### Friya, Isaac, Jamima, Acelya, Viktor, Abdurashid, Amaar, Tarif

# Sprint 2 - Review and Retrospective

### Sprint Review

#### **Sprint Goal and Demoed Features**

Sprint Goal: have some integrated back end.

| Demoed Feature | Feedback   |
|----------------|------------|
| Demod download and delete feature | Integrate backend    |
| Demod login and registration and emergency contact information form | UI improvement needed  |
| Email progress | consider using gmail smpt instead  |
| improved front end design | looks better and functional  |



#### **Completed Tasks**

####  Epic-User Story ID User Registration - 001

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|001          | Set up database for user registration |Friya | Yes |

####  Epic-User Story ID User Login - 002

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|002          | Set up database for login  |Friya  | Yes |

####  Epic-User Story ID 2FA - 003

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|002-2 | set up 2FA code to send to email  |Friya | No |
|002-2 | set up 2FA front end where code can be inputted  |Friya | No |

####  Epic-User Story ID Forgot Password link - 004

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|002-2 | set up forgot password link, front end  |Friya | No |
|002-2 | set up forgot password link to send email and reset it in the backend |Friya | No |


####  Epic-User Story ID Downloading data - 006

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|006-1 | integrate database structure for storing user data  |Isaac | No |
|006-2 | implement UI button for downloading user data |Isaac | Yes |
|006-3 | Develop API to store and retrieve data from the database and export in CSV format |Isaac | No |
|006-4 | Implement user authentication to prevent unauthorised downloads |Isaac | No |


####  Epic-User Story ID storing data - 007

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|007-1 | implement database structure for storing user data |Isaac | No |

#### Improved front end design (chatbox) - 010

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|010-1 | Functional chatbox form that holds user input into variable | Viktor | Yes |
|010-2 | Hook LLM responses into answer textbox with distinctive decoration from user message | Viktor | No |
|010-3 | Convert chatbox into a single component that can be imported into other front-ends | Viktor | No |

#### Read and Update from and to backend API and LLM API - 011

| **Task ID** | **Description** | **Assigned To** | **Done?**| 
| ------------| ----------------| ----------------| -----------|
|011-1 | Read user data (context) upon running application | Viktor | No |
|011-2 | Feed user data (context) through LLM API | Viktor | No |
|011-3 | Create mock backend for testing purposes (not integrated) | Viktor | No |
|011-4 | Instruct LLM to summarise latest conversation and write to backend API | Viktor | No |

####  Epic-User Story ID storing data - 007

|**Task ID**| **Description**| **Assigned To**| **Done?**|
| ------------| ----------------| ----------------| -----------|
|001-5 |   Implemented new UI design | Jamima | Yes |
|001-6| Improved user experience | Jamima | Yes |
|002-4 | Started spring boot setup | Jamima | Yes |


### New/Revised Tasks

**Instructions:** Add any new tasks coming from the review that wasn't previously in the backlog. Below is an example. Remove the example and add yours.

####  Epic-User Story ID Emergency Contact Infromation 005

| **Task ID** | **Description** |
|-------------|-----------------|
| 005 | Complete an emergency contact information survey |
| 005-1| allow users to update their emergency contact information |
| 005-2 | allow users to delete their emergency contact information |
| 005-3 | all information and actions gets fed into the back end |


####  Epic-User Story ID Downloading user data 007

| **Task ID** | **Description** |
|-------------|-----------------|
| 007-1 | Implement UI button for deleting user data |
| 007-2 | when downloading data users can open a json file |




### Sprint Retrospective

#### **Discussion**

| What went well | What could have gone better | What will we do differently?|
|----------------|-----------------------------|-------------|
| We have made progress, identified the main databse. login and reg features, download and delete features have been established and have a good skelton. Front end is going well               | more backend implementation    | communicate more and hold and attend more meetings to discuss ways we can integrate code  |



# Sprint 3 Plan

### Sprint Goal

To integrate backend, to work more collaborately so we can have one working front and back end

### Sprint Leads
- product owner - Jamima
- scrum master - Viktor 

### Sprint Backlog


1.  Epic-User Story ID User Registration 001
 **Acceptance criteria:**
User can register in the app

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|001-1        | Better the UI for registration | 3 |     Friya      |

2.  Epic-User Story ID User Login 002
 **Acceptance criteria:**
User can login to the app

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|001-1| Better the UI for login |        3        |      Friya      |

3.  Epic-User Story ID Emergency Contact Information 005
 **Acceptance criteria:**
User can log emergency contact information

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|005-1| Better the UI for emergency contact information | 3 | Friya |

4.  Epic-User Story ID Downloading user data 007
 **Acceptance criteria:**
user can downloiad their data in a json/PDF file

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|007-2| implement database where users can download that information | 8 | Isaac |

5.  Epic-User Story ID Deleting user data 008
 **Acceptance criteria:**
user can downloiad their data in a json/PDF file

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|008-1| implement database where users can delete that information | 8 | Isaac |
|008-2| log the user/instance of deletion | 5 | Isaac |

6. Epic user story ID users creating and saving the entries and goals 002

**Acceptance criteria:**
user can create and save their journal entries and goals (Backend)

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
|002 - 6 | Develop inital API endpoints | 8| Jamima 
|002-7| Integrate database with backend | 8| Jamima 

7. Frontend 010

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
010-5 | Improve chatbox to be a button that shows up when pressed | 3 | Viktor |
010-6 | Integrate chatbot as component for other front end interfaces | 3 | Viktor | 

8. Backend 011

| **Task ID** | **Description** | **Story Point** | **Assigned To** |
| ------------| ----------------| ----------------| ----------------|
011-4 | Hard code default user interactions with LLM | 8 | Viktor |
011-5 | Implement API calls for LLM to read user input, respond and store conversation data in backend | 3 | Viktor | 



# Appendix - Project Backlog


| Epic              | US ID* | As a .. | I want to .. | So that ... | F/NF/UI** | Priority|
| ----------------- | ------ | ------------- | ------- | ------- |-------- | ----- |
| User registration | 001    | User | Have an nice and clear user interface when registering | the application is easier to use | F | High |
| User login | 002    | User | Have an nice and clear user interface when loging in | the application is easier to use | F | High |
| Emergency contact information | 002    | User | Have an nice and clear user interface filling out emergency contact information | the application is easier to use | F | High |
| downloading data | 007    | User | downlaod my data  | i can view it on a PDF | F | High |
| deleting user data | 008    | User | delete my data | the organisation doesnt have any of my information | F | High |


