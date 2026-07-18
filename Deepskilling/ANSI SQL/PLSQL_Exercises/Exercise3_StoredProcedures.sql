SET SERVEROUTPUT ON;

--------------------------------------------------------
-- Scenario 1
-- Process Monthly Interest
--------------------------------------------------------

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly Interest Processed');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

BEGIN
    ProcessMonthlyInterest;
END;
/

--------------------------------------------------------
-- Scenario 2
-- Update Employee Bonus
--------------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(

    p_Department VARCHAR2,
    p_Bonus NUMBER

)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_Bonus / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee Bonus Updated');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

--------------------------------------------------------
-- Scenario 3
-- Transfer Funds
--------------------------------------------------------

CREATE OR REPLACE PROCEDURE TransferFunds(

    p_FromAccount NUMBER,
    p_ToAccount NUMBER,
    p_Amount NUMBER

)
IS

    v_Balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

BEGIN
    TransferFunds(1,2,500);
END;
/