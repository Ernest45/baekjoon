--상반기 아이스크림 총주문량이 3,000보다 높으면서
--아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.


SELECT F.FLAVOR
FROM FIRST_HALF F INNER JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR
WHERE (F.TOTAL_ORDER > 3000) AND (I.INGREDIENT_TYPE = "fruit_based")
ORDER BY F.TOTAL_ORDER DESC;