CREATE TABLE "SOMSITH_Media" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "category" VARCHAR(45) NOT NULL,
  "price" INTEGER NOT NULL,
  "quantity" INTEGER NOT NULL,
  "title" VARCHAR(45) NOT NULL,
  "value" INTEGER NOT NULL,
  "imageUrl" VARCHAR(45) NOT NULL
);

CREATE TABLE "SOMSITH_CD" (
  "id" INTEGER PRIMARY KEY NOT NULL,
  "artist" VARCHAR(45) NOT NULL,
  "recordLabel" VARCHAR(45) NOT NULL,
  "musicType" VARCHAR(45) NOT NULL,
  "releasedDate" DATE
);

CREATE TABLE "SOMSITH_Book" (
  "id" INTEGER PRIMARY KEY NOT NULL,
  "author" VARCHAR(45) NOT NULL,
  "coverType" VARCHAR(45) NOT NULL,
  "publisher" VARCHAR(45) NOT NULL,
  "publishDate" DATETIME NOT NULL,
  "numOfPages" INTEGER NOT NULL,
  "language" VARCHAR(45) NOT NULL,
  "bookCategory" VARCHAR(45) NOT NULL
);

CREATE TABLE "SOMSITH_DeleveryInfo" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" VARCHAR(45),
  "province" VARCHAR(45),
  "instructions" VARCHAR(200),
  "address" VARCHAR(100)
);

CREATE TABLE "SOMSITH_Card" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "cardCode" VARCHAR(15) NOT NULL,
  "owner" VARCHAR(45) NOT NULL,
  "cvvCode" VARCHAR(3) NOT NULL,
  "dateExpired" VARCHAR(4) NOT NULL
);

CREATE TABLE "SOMSITH_DVD" (
  "id" INTEGER PRIMARY KEY NOT NULL,
  "discType" VARCHAR(45) NOT NULL,
  "director" VARCHAR(45) NOT NULL,
  "runtime" INTEGER NOT NULL,
  "studio" VARCHAR(45) NOT NULL,
  "subtitle" VARCHAR(45) NOT NULL,
  "releasedDate" DATETIME
);

CREATE TABLE "SOMSITH_Order" (
  "id" INTEGER NOT NULL,
  "shippingFees" VARCHAR(45),
  "deleveryInfoId" INTEGER NOT NULL,
  PRIMARY KEY ("id", "deleveryInfoId")
);

CREATE TABLE "SOMSITH_OrderMedia" (
  "orderID" INTEGER NOT NULL,
  "price" INTEGER NOT NULL,
  "quantity" INTEGER NOT NULL,
  "mediaId" INTEGER NOT NULL,
  PRIMARY KEY ("orderID", "mediaId")
);

CREATE TABLE "SOMSITH_Invoice" (
  "id" INTEGER PRIMARY KEY NOT NULL,
  "totalAmount" INTEGER NOT NULL,
  "orderId" INTEGER NOT NULL
);

CREATE TABLE "SOMSITH_PaymentTransaction" (
  "id" INTEGER NOT NULL,
  "createAt" DATETIME NOT NULL,
  "content" VARCHAR(45) NOT NULL,
  "method" VARCHAR(45),
  "cardId" INTEGER NOT NULL,
  "invoiceId" INTEGER NOT NULL,
  PRIMARY KEY ("id", "cardId", "invoiceId")
);

ALTER TABLE "SOMSITH_CD" ADD FOREIGN KEY ("id") REFERENCES "SOMSITH_Media" ("id");

ALTER TABLE "SOMSITH_Book" ADD FOREIGN KEY ("id") REFERENCES "SOMSITH_Media" ("id");

ALTER TABLE "SOMSITH_DVD" ADD FOREIGN KEY ("id") REFERENCES "SOMSITH_Media" ("id");

ALTER TABLE "SOMSITH_Order" ADD FOREIGN KEY ("deleveryInfoId") REFERENCES "SOMSITH_DeleveryInfo" ("id");

ALTER TABLE "SOMSITH_OrderMedia" ADD FOREIGN KEY ("orderID") REFERENCES "SOMSITH_Order" ("id");

ALTER TABLE "SOMSITH_OrderMedia" ADD FOREIGN KEY ("mediaId") REFERENCES "SOMSITH_Media" ("id");

ALTER TABLE "SOMSITH_Invoice" ADD FOREIGN KEY ("orderId") REFERENCES "SOMSITH_Order" ("id");

ALTER TABLE "SOMSITH_PaymentTransaction" ADD FOREIGN KEY ("cardId") REFERENCES "SOMSITH_Card" ("id");

ALTER TABLE "SOMSITH_PaymentTransaction" ADD FOREIGN KEY ("invoiceId") REFERENCES "SOMSITH_Invoice" ("id");

CREATE INDEX "aims.Order.fk_Order_DeleveryInfo1_idx" ON "SOMSITH_Order" ("deleveryInfoId");

CREATE INDEX "aims.OrderMedia.fk_ordermedia_order_idx" ON "SOMSITH_OrderMedia" ("orderID");

CREATE INDEX "aims.OrderMedia.fk_OrderMedia_Media1_idx" ON "SOMSITH_OrderMedia" ("mediaId");

CREATE INDEX "aims.Invoice.fk_Invoice_Order1_idx" ON "SOMSITH_Invoice" ("orderId");

CREATE INDEX "aims.PaymentTransaction.fk_PaymentTransaction_Card1_idx" ON "SOMSITH_PaymentTransaction" ("cardId");

CREATE INDEX "aims.PaymentTransaction.fk_PaymentTransaction_Invoice1_idx" ON "SOMSITH_PaymentTransaction" ("invoiceId");
