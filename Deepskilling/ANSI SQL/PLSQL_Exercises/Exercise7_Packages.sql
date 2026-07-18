SET SERVEROUTPUT ON;

--------------------------------------------------------
-- PACKAGE 1 : CustomerManagement
--------------------------------------------------------

CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_ID NUMBER,
        p_Name VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_ID NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        VALUES(
            p_ID,
            p_Name,
            p_DOB,
            p_Balance,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Customer Added');

    END;

    PROCEDURE UpdateCustomer(
        p_ID NUMBER,
        p_Name VARCHAR2
    )
    IS
    BEGIN

        UPDATE Customers
        SET Name = p_Name
        WHERE CustomerID = p_ID;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Customer Updated');

    END;

    FUNCTION GetCustomerBalance(
        p_ID NUMBER
    )
    RETURN NUMBER
    IS
        v_Balance NUMBER;
    BEGIN

        SELECT Balance
        INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_ID;

        RETURN v_Balance;

    END;

END CustomerManagement;
/

--------------------------------------------------------
-- PACKAGE 2 : EmployeeManagement
--------------------------------------------------------

CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_ID NUMBER,
        p_Salary NUMBER
    );

    FUNCTION AnnualSalary(
        p_ID NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    )
    IS
    BEGIN

        INSERT INTO Employees
        VALUES(
            p_ID,
            p_Name,
            p_Position,
            p_Salary,
            p_Department,
            SYSDATE
        );

        COMMIT;

    END;

    PROCEDURE UpdateEmployee(
        p_ID NUMBER,
        p_Salary NUMBER
    )
    IS
    BEGIN

        UPDATE Employees
        SET Salary = p_Salary
        WHERE EmployeeID = p_ID;

        COMMIT;

    END;

    FUNCTION AnnualSalary(
        p_ID NUMBER
    )
    RETURN NUMBER
    IS

        v_Salary NUMBER;

    BEGIN

        SELECT Salary
        INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_ID;

        RETURN v_Salary * 12;

    END;

END EmployeeManagement;
/

--------------------------------------------------------
-- PACKAGE 3 : AccountOperations
--------------------------------------------------------

CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_Type VARCHAR2,
        p_Balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    );

    FUNCTION TotalBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_Type VARCHAR2,
        p_Balance NUMBER
    )
    IS
    BEGIN

        INSERT INTO Accounts
        VALUES(
            p_AccountID,
            p_CustomerID,
            p_Type,
            p_Balance,
            SYSDATE
        );

        COMMIT;

    END;

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    )
    IS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;

        COMMIT;

    END;

    FUNCTION TotalBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS

        v_Total NUMBER;

    BEGIN

        SELECT SUM(Balance)
        INTO v_Total
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN NVL(v_Total,0);

    END;

END AccountOperations;
/

--------------------------------------------------------
-- TEST CUSTOMER PACKAGE
--------------------------------------------------------

BEGIN
    CustomerManagement.AddCustomer(
        100,
        'Peter',
        TO_DATE('1995-08-10','YYYY-MM-DD'),
        20000
    );
END;
/

SELECT CustomerManagement.GetCustomerBalance(100)
FROM DUAL;

--------------------------------------------------------
-- TEST EMPLOYEE PACKAGE
--------------------------------------------------------

SELECT EmployeeManagement.AnnualSalary(1)
FROM DUAL;

--------------------------------------------------------
-- TEST ACCOUNT PACKAGE
--------------------------------------------------------

SELECT AccountOperations.TotalBalance(1)
FROM DUAL;