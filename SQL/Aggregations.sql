/*Write a SQL query to find the number of matches that ended in draws.*/
select count(*) from match_mast
where results='Draw';

/*Write a SQL query to find out when the Football EURO Cup 2016 will begin.*/
select min(play_date) as Beginning_Date
 from match_mast

/*Write a SQL query to find the number of self-goals scored during the 2016 European Championship.*/
