
## Drones Service REST API


---

:scroll: **START**


### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Task description

We have a fleet of **10 drones**. A drone is capable of carrying devices, other than cameras, and capable of delivering small loads. For our use case **the load is medications**.

A **Drone** has:
- serial number (100 characters max);
- model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
- weight limit (500gr max);
- battery capacity (percentage);
- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has: 
- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).

Develop a service via REST API that allows clients to communicate with the drones (i.e. **dispatch controller**). The specific communicaiton with the drone is outside the scope of this task. 

The service should allow:
- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone; 
- checking available drones for loading;
- check drone battery level for a given drone;

> Feel free to make assumptions for the design approach. 

---

### Requirements

While implementing your solution **please take care of the following requirements**: 

#### Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

---

#### Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

---


### Testing the API
- Some of the assumption made for the purpose of this API design are:-

Open Postman For testing purpose the API is secured and you will have to specify the Authorization in the headers as Basic Auth

Username **admin**

Password **admin**

Note: the ContentType is application/json
----
- **Register a Drone**
 
      curl --location 'http://127.0.0.1:8080/api/drone/register' \
      --header 'Authorization: Basic YWRtaW46YWRtaW4=' \
      --header 'Content-Type: application/json' \
      --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0' \
      --data '{
          "serialNumber":"Q23RT5676698",
          "model":"Sonny",
          "weightLimit":"430.0",
          "battery":"0.98",
          "state":"IDLE"
      }'
![image](https://user-images.githubusercontent.com/13887312/226552739-1c56c7cf-15bf-4b65-86c5-19eb4c7af074.png)

----
- **Checking loaded medication items for a given drone**

    curl --location 'http://127.0.0.1:8080/api/drone/available' \
    --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0'
    
    ![image](https://user-images.githubusercontent.com/13887312/226552939-af034e69-6038-4344-a8c2-a69d82b6fe5b.png)

----
- **Loading a drone with medication items**

     curl --location 'http://127.0.0.1:8080/api/drone/load' \
     --header 'Content-Type: application/json' \
     --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0' \
     --data '{
         "serialNumber":"Q23RT5676698",
         "code":"WE232344",
         "source":"Nairobi",
         "detination":"Mumbai"
     }'
     
     ![image](https://user-images.githubusercontent.com/13887312/226553011-c915447f-d857-4112-a565-e4e4bff4ec54.png)

----
 - **Checking loaded medication items for a given drone**

    curl --location 'http://127.0.0.1:8080/api/drone/details/Q23RT5676698' \
    --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0'

![image](https://user-images.githubusercontent.com/13887312/226553092-a2c63cc9-5ce8-49f9-a485-26603396f2ea.png)

----
- ** Check drone battery level for a given drone**

   curl --location 'http://127.0.0.1:8080/api/drone/battery' \
   --header 'Content-Type: application/json' \
   --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0' \
   --data '{
       "serialNumber":"Q23RT5676698"
   }'
   
 ![image](https://user-images.githubusercontent.com/13887312/226553299-8e295712-d258-4b53-961d-c2cfff6e1056.png)


----
 - **Delivery of medication item**

   curl --location 'http://127.0.0.1:8080/api/drone/deliver' \
   --header 'Content-Type: application/json' \
   --header 'Cookie: JSESSIONID=1AD5EBEF85960DC41F2EFFDFBDBEB2D0' \
   --data '{
       "serialNumber":"Q23RT5676698"
   }'
![image](https://user-images.githubusercontent.com/13887312/226553415-f05cbc21-a69d-45eb-9f5e-067f184674f4.png)

----
