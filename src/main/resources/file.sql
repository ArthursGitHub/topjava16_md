1)
CREATE TABLE table1
(
  field1 bigint NOT NULL,
  field2 integer NOT NULL,
  field3 integer NOT NULL,
  str text DEFAULT 123,
  CONSTRAINT table1_pkey PRIMARY KEY (field1)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE table1
  OWNER TO pleasing;

CREATE INDEX ix_table1
  ON table1
  USING btree
  (field2);

CREATE INDEX ix_table11
  ON table1
  USING btree
  (str);

2)
INSERT INTO table1
  SELECT i, i,i
  FROM generate_series(1, 1000000) AS i;

3)
--REINDEX TABLE table1;
EXPLAIN ANALYZE
SELECT * FROM table1 CCV
  where  CCV.field1 = 6
;

--REINDEX TABLE table1;
EXPLAIN ANALYZE
SELECT * FROM table1 CCV
  where  CCV.str like 'se3'
;

4)
--REINDEX TABLE table1;


===================================== result =======================================
1)
"Index Scan using ix_table1 on table1 ccv  (cost=0.43..8.45 rows=1 width=20) (actual time=0.016..0.017 rows=1 loops=1)"
"  Index Cond: (field3 = 6)"
"Planning time: 0.076 ms"
"Execution time: 0.043 ms"

2)
"Index Scan using ix_table11 on table1 ccv  (cost=0.43..4.45 rows=1 width=20) (actual time=0.019..0.019 rows=0 loops=1)"
"  Index Cond: (str = 'se3'::text)"
"  Filter: (str ~~ 'se3'::text)"
"Planning time: 0.080 ms"
"Execution time: 0.038 ms"

3) без индекса
"Seq Scan on table1 ccv  (cost=0.00..93384.01 rows=1 width=20) (actual time=0.014..945.935 rows=1 loops=1)"
"  Filter: (field2 = 6)"
"  Rows Removed by Filter: 5000000"
"Planning time: 0.068 ms"
"Execution time: 946.979 ms"
