ALTER TABLE orders ADD COLUMN if not exists mail VARCHAR(255) DEFAULT 'unknown@email.com' NOT NULL;

ALTER TABLE orders ALTER COLUMN mail DROP DEFAULT;