-- 코드를 입력하세요
WITH RECURSIVE outs_cte AS(
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1 FROM outs_cte
    WHERE HOUR < 23
)
SELECT outs_cte.HOUR,
        COUNT(ANIMAL_ID)AS COUNT
FROM outs_cte
    LEFT OUTER JOIN ANIMAL_OUTS B
        ON outs_cte.HOUR = HOUR(B.DATETIME)
GROUP BY outs_cte.HOUR
ORDER BY outs_cte.HOUR