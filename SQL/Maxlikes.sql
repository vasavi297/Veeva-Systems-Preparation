/*Write a query to Determine the song which has highest number of likes in every playlist. 
Output 4 columns namely playlist_id , song_id , song_name and maximum like count as max_likes*/
with likes as(
select l.song_id,s.song_name,count(l.user_id)as like_count
from liked_by l
join song s on l.song_id=s.song_id
group by l.song_id,s.song_name),
rankedsongs as(select bt.playlist_id,lc.song_id,  
        lc.song_name,  
        lc.like_count,  
        ROW_NUMBER() OVER (
            PARTITION BY bt.playlist_id  
            ORDER BY lc.like_count DESC, lc.song_id ASC  
        ) AS rnk  
    FROM Belongs_To bt
    JOIN likes lc ON bt.song_id = lc.song_id 
)
select playlist_id,song_id,song_name,like_count as max_likes
from rankedsongs
where rnk=1;
