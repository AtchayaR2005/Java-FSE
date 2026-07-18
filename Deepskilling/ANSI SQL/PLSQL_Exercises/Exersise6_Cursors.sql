SET SERVEROUTPUT ON;

--------------------------------------------------------
-- Scenario 1
-- Generate Monthly Statements
--------------------------------------------------------

DECLARE

    CURSOR c_transactions IS
    SELECT c.Name,
           t.TransactionID,
           t.TransactionDate,
           t.Amount,
           t.TransactionType
    FROM Customers c
    JOIN Accounts a
    ON c.CustomerID = a.CustomerID
    JOIN Transactions t
    ON a.AccountID = t.AccountID
    WHERE EXTRACT(MONTH FROM t.TransactionDate) =
          EXTRACT(MONTH FROM SYSDATE);

BEGIN

    FOR rec IN c_transactions LOOP

        DBMS_OUTPUT.PUT_LINE(
        'Customer : ' || rec.Name ||
        ' | Transaction ID : ' || rec.TransactionID ||
        ' | Amount : ' || rec.Amount ||
        ' | Type : ' || rec.TransactionType);

    END LOOP;

END;
/

--------------------------------------------------------
-- Scenario 2
-- Apply Annual Maintenance Fee
--------------------------------------------------------

DECLARE

    CURSOR c_accounts IS
    SELECT AccountID
    FROM Accounts;

BEGIN

    FOR rec IN c_accounts LOOP

        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = rec.AccountID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual Fee Applied');

END;
/

--------------------------------------------------------
-- Scenario 3
-- Update Loan Interest Rates
--------------------------------------------------------

DECLARE

    CURSOR c_loans IS
    SELECT LoanID, InterestRate
    FROM Loans;

BEGIN

    FOR rec IN c_loans LOOP

        UPDATE Loans
        SET InterestRate = rec.InterestRate + 0.5
        WHERE LoanID = rec.LoanID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan Interest Updated');

END;
/