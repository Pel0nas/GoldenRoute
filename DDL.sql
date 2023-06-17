CREATE SCHEMA IF NOT EXISTS operations;
CREATE TABLE IF NOT EXISTS operations.operation_details(
	cargo_weight numeric,
	min_takeoff_distance numeric,
	cargo_to_destroy numeric,
	takeoff_time numeric,
	PRIMARY KEY (cargo_weight)
);