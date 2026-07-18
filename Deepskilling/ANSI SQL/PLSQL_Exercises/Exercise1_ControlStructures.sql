SET SERVEROUTPUT ON;

----------------------------------------------------
-- Scenario 1
-- Apply 1% discount to loan interest for customers
-- above 60 years old
----------------------------------------------------

BEGIN
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate
        FROM Loans l
        JOIN Customers c
        ON l.CustomerID = c.CustomerID
        WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated.');
END;
/

----------------------------------------------------
-- Scenario 2
-- Set VIP flag for customers with balance >10000
----------------------------------------------------

ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP='TRUE'
        WHERE CustomerID=rec.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated.');
END;
/

----------------------------------------------------
-- Scenario 3
-- Loan due within next 30 days
----------------------------------------------------

BEGIN
    FOR rec IN(
        SELECT c.Name,l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID=l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
        'Reminder : '
        ||rec.Name||
        ' Loan Due Date : '
        ||TO_CHAR(rec.EndDate,'DD-MON-YYYY'));
    END LOOP;
END;
/