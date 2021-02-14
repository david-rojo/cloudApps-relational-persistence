ALTER TABLE flight 
ADD crew_json JSON NOT NULL;

UPDATE flight f
SET f.crew_json = (
    SELECT JSON_ARRAYAGG(
    	JSON_OBJECT('employee_code', fc.crewmember_employee_id))
    FROM flight_crewmember fc
    WHERE fc.flight_flight_id = f.flight_id);
    
ALTER TABLE airplane
ADD revisions_json JSON NOT NULL;
 
UPDATE airplane a
SET revisions_json = (
    SELECT JSON_ARRAYAGG(
    	JSON_OBJECT(
        	'id',r.id,
        	'description', r.description,
        	'start_date', r.start_date,
        	'end_date', r.end_date,        
        	'spent_hours', r.spent_hours,
        	'revision_type', r.revision_type,
        	'airport_id', r.airport_id,
        	'employee_id', r.employee_id))
    FROM revision r
    WHERE r.airplane_id = a.airplane_id);