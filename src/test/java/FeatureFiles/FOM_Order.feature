
Feature:GTM | FOM | Switch To Fulfillment view Details Validation
@Fulfillmentvalidation
 Scenario: Launch app and search for order
    Given application url "https://ehis-dev1.login.us6.oraclecloud.com/" is launched
    When Enter "p.t@f5.com" in RMCS User ID field
    And Enter "Pradeep$54321" in RMCS Password field
    When Click on RMCS Login button
    Then RMCS home page should be displayed
    --------------Schedule New Process--------------
    When Click NavigationIcon
    When Click "Order Management" link from Navigator
    And Open "Tasks"
    And Click  "Manage Orders"
    And Enter "4331" in Order Number input Field
    And click  Search
    And Click  "4331" link
    And open "Actions"
     And Click "Switch to Fulfillment View"
     Then Validate Header Fields
    | Customer              | Computer Associates|
    | Purchase Order        | test4331po         |
    | Status                | Processing         |
    | Source Order System   | ORA_BM_CPQ         |
    | Source Order          | F5Q-009912         |
    | Source Document Type  | Sales order        |
    | Business Unit         | CORPORATE          |
    
     And click "Order Lines"
     Then Validate Each Order Line Details
     And Validate each order line All SKUS are displayed
  
    | ordered quantity  |
    | uom              |
    | status            |
      And click "Fulfillment Lines"
    Then Validate Each Item under Fulfillment Line
   
    
  | item             |
  | item description |
  | uom              |
  | order            |
  | source order     |
  
  When Click Each line under "Fulfillment Lines"
     Then Validate General Tab fields
     
      | uom                                  | Year                                             |
      | status                               | Closed                                           |
      | source order system                  | ORA_BM_CPQ                                       |
      | item                                 | F5-AFM-25M-PRM-SUB                               |
      | item description                     | BIGIP: VE SUBSCRIPTION AFM 25M (PREMIUM SUPPORT) |
      | fulfillment line                     | 1-1                                              |
      | order                                | 4331                                             | 
      | source order                         | F5Q-009912                                       |
      | unit list price                      | 134.40 USD                                       | 
      | unit selling price                   | 134.40 USD                                       |
      | order transactional value            | 61,736.32 USD                                    |
      | order standardized value             | 61,736.32 USD                                    |
      | fulfillment line transactional value | 134.40 USD                                       |
      | fulfillment line standardized value  | 134.40 USD                                       |
      | customer                             | Computer Associates                              |
       
       
     
     
     |                                                |              |                  |             |                            |                              | 
     | Year | Closed | ORA_BM_CPQ          | F5-ADD-LTM-25MPRMSUB   | BIG-IP: VE Subscription Add LTM 25M (Premium Support)                                      | 1.1-1            | 4331  | F5Q-009912    | 134.40 USD      | 134.40 USD         | 61,736.32 USD              | 61,736.32 USD            | 134.40 USD                           | 134.40 USD                             | Computer Associates |
      | Year | Closed | ORA_BM_CPQ          | F5-ADD-APM-25M-PRMSUB  | BIG-IP Virtual Edition Add-on License for Access Policy Manager 25 Mbps (500 SSLVPN)       | 1.2-1            | 4331  | F5Q-009912    | 222.60 USD      | 222.60 USD         | 61,736.32 USD              | 61,736.32 USD            | 222.60 USD                           | 222.60 USD                             | Computer Associates |
     | Year | Closed | ORA_BM_CPQ          | F5-BIG-LTM-R2800       | BIGIP APPLIANCE: LOCAL TRAFFIC MANAGER R2800 (32G, M.2 SSD, BASE SSL & COMP)(MODEL R2000)  | 2-1              | 4331  | F5Q-009912    | 40,424.60 USD   | 40,424.60 USD      | 61,736.32 USD              | 61,736.32 USD            | 40,424.60 USD                        | 40,424.60 USD                          | Computer Associates |
      | Year | Closed | ORA_BM_CPQ          | F5-SVC-BIG-PRE-L1-3    | BIG-IP Service: Premium (Level 1-3) 17% of List                                            | 2:1-1            | 4331  | F5Q-009912    | 2,021.23	USD    | 2,021.23 USD       | 61,736.32 USD              | 61,736.32 USD            | 2,021.23 USD                         | 2,021.23 USD                           | Computer Associates |
      | Year | Closed | ORA_BM_CPQ          | F5-ADD-BIG-AFM-R2XXX   | BIGIP ADDON: ADVANCED FIREWALL MANAGER MODULE R2XXX                                        | 2.1-1            | 4331  | F5Q-009912    | 18,371.90 USD   | 18,371.90 USD      | 61,736.32 USD              | 61,736.32 USD            | 18,371.90	USD                        | 18,371.90	USD                         | Computer Associates |
      | Year | Closed | ORA_BM_CPQ          |F5-SVC-BIG-PRE-L1-3     | BIG-IP Service: Premium (Level 1-3) 17% of List                                            |2.1:1-1           | 4331  | F5Q-009912    | 918.60 USD      | 918.60 USD         | 61,736.32 USD              | 61,736.32 USD            | 918.60 USD                           | 918.60 USD                             | Computer Associates |
      | Year | Closed | ORA_BM_CPQ          |PRD-09596-00            | PANTERA LOW APPLIANCE, (MODEL R2000)                                                       | 2.2-1            | 4331  | F5Q-009912    | 0.00	USD        | 0.00 USD           | 61,736.32 USD              | 61,736.32 USD            | 0.00 USD                             | 0.00 USD                               | Computer Associates |
      
      
      When Click "Orchestration" process Number
      Then validate "Asset Management"  task progress should be completed
      And "Subscription" task progress should be completed
      And Click Done Button
      And "Fulfillment Line" Should be displayed
      And Click Done Button
      And "Order" should be displayed
      
    