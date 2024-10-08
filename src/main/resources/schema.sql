CREATE TABLE PRICES (
  BRAND_ID INT,
  START_DATE TIMESTAMP,
  END_DATE TIMESTAMP,
  PRICE_LIST INT,
  PRODUCT_ID INT,
  PRIORITY INT,
  PRICE DECIMAL(10,2),
  CURR CHAR(3),
   PRIMARY KEY (brand_id, start_date, product_id, priority)
);