SET SERVEROUTPUT ON;

--------------------------------------------------------
-- Scenario 1
-- Calculate Age
--------------------------------------------------------

CREATE OR REPLACE FUNCTION CalculateAge(
    p_DOB DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN
    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB)/12);
    RETURN v_Age;
END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

SELECT CalculateAge(TO_DATE('1995-06-15','YYYY-MM-DD')) AS Age
FROM DUAL;

--------------------------------------------------------
-- Scenario 2
-- Calculate Monthly Installment
--------------------------------------------------------

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(

    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_Years NUMBER

)
RETURN NUMBER
IS
    v_Result NUMBER;
BEGIN

    v_Result :=
    (p_LoanAmount +
    (p_LoanAmount*p_InterestRate*p_Years/100))
    /(p_Years*12);

    RETURN v_Result;

END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

SELECT CalculateMonthlyInstallment(
100000,
10,
5
) AS EMI
FROM DUAL;

--------------------------------------------------------
-- Scenario 3
-- Has Sufficient Balance
--------------------------------------------------------

CREATE OR REPLACE FUNCTION HasSufficientBalance(

    p_AccountID NUMBER,
    p_Amount NUMBER

)
RETURN VARCHAR2
IS

    v_Balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID=p_AccountID;

    IF v_Balance>=p_Amount THEN
        RETURN 'YES';
    ELSE
        RETURN 'NO';
    END IF;

END;
/

--------------------------------------------------------
-- Execute
--------------------------------------------------------

SELECT HasSufficientBalance(
1,
500
) AS STATUS
FROM DUAL;