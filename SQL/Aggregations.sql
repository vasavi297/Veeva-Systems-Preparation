/*Write a SQL query to find the number of matches that ended in draws.*/
select count(*) 
from match_mast
where results='Draw';

/*Write a SQL query to find out when the Football EURO Cup 2016 will begin.*/
select min(play_date) as Beginning_Date
from match_mast;

/*Write a SQL query to find the number of self-goals scored during the 2016 European Championship.*/
select count(*) 
from goal_details
where goal_type='O';

/*Write a SQL query to count the number of matches that ended with a result in the group stage.*/
select count(*) 
from match_mast 
where play_stage='G';

/*Write a SQL query to find the number of matches that resulted in a penalty shootout.*/
select count(distinct match_no) 
from penalty_shootout;

/*Write a SQL query to find the number of matches decided by penalties in the Round 16.*/
SELECT COUNT(*)
FROM match_mast
WHERE play_stage = 'R16'
AND decided_by = 'P';

/*Write a SQL query to find the number of goals scored in every match within a normal play schedule. 
Sort the result-set on match number. Return match number and number of goals scored.*/
select match_no,count(*)
from goal_details
where goal_schedule='NT'
group by match_no
order by match_no;

/*Write a SQL query to find the matches in which no stoppage time was added during the first half of play. 
Return match number, date of play, and goal scored.*/
select match_no,play_date,goal_score
from match_mast
where stop1_sec='0';

/*Write a SQL query to count the number of bookings that happened in extra time.*/
select count(*) from player_booked
where play_schedule='ET';

/*Write a SQL query to count the number of bookings during stoppage time.*/
SELECT COUNT(*)
FROM player_booked
WHERE booking_time > 45
AND booking_time <= 90;