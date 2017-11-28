INSERT INTO lottery.players(
            id, username, password, firstname, lastname, sex, identitycardnumber, 
            dob, country, zipcode, city, address, phonenumber, email, createddate)
    VALUES (4, 'SETTLEMENTTEST1', 'settlementtest1', 'Jack', 'Test', 1, '123456AB', 19851114, 'UK', '53CE', 'London', 'Test St.', '+12 123 123 123', 'settlementtest1@settlement.com', '2016-12-12'),(5,'SETTLEMENTTEST2','settlementtest2','Jane','Test',0,'123456AC',19900731,'US','New York','4321','Vertes St.','+12 123 321 321','settlementtest2@gmail.com','2015-11-10');


INSERT INTO lottery.lotterydraws(
            id, basestake, gridsize, numbersdrawn, nrofgrids, minnroffox, 
            maxnroffix, maxnrofcombination, year, week, status, winningnumbers, 
            lotterygameid, createdate)
    VALUES (3, 500, 90, 5, 4, 1, 
            5, 4, '2017', 52, 'closed', '71,72,73,74,75', 
            1, '2017-09-05');

INSERT INTO lottery.lotterytickets(
            id, playerid, lotterydrawid, stake, fixnumbers, combinationnumbers, 
            createdate)
    VALUES (3, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(4, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(5, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(6, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(7, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(8, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(9, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(10, 4, 3, 2000, 5, 0, 
            '2017-12-01'),(11, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(12, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(13, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(14, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(15, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(16, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(17, 5, 3, 2000, 5, 0, 
            '2017-12-01'),(18, 5, 3, 2000, 5, 0, 
            '2017-12-01');			

INSERT INTO lottery.transactions(
            id, type, amount, playerid, createdate)
    VALUES (3, 'Bet', 2000, 4, '2017-12-01'),(4, 'Bet', 2000, 4, '2017-12-01')
			,(5, 'Bet', 2000, 4, '2017-12-01'),(6, 'Bet', 2000, 4, '2017-12-01')
			,(7, 'Bet', 2000, 4, '2017-12-01'),(8, 'Bet', 2000, 4, '2017-12-01')
			,(9, 'Bet', 2000, 4, '2017-12-01'),(10, 'Bet', 2000, 5, '2017-12-01')
			,(11, 'Bet', 2000, 5, '2017-12-01'),(12, 'Bet', 2000, 5, '2017-12-01')
			,(13, 'Bet', 2000, 5, '2017-12-01'),(14, 'Bet', 2000, 5, '2017-12-01')
			,(15, 'Bet', 2000, 5, '2017-12-01'),(16, 'Bet', 2000, 5, '2017-12-01')
			,(17, 'Bet', 2000, 5, '2017-12-01');
			
INSERT INTO lottery.singleselections(
            id, selection, lotteryticketid)
    VALUES (3, '1,2,3,4,5', 3),(4, '1,2,3,4,5', 3)
		  ,(5, '1,2,3,4,5', 3),(6, '1,2,3,4,5', 3)
		  ,(7, '1,2,3,4,5', 4),(8, '1,2,3,4,5', 4)
		  ,(9, '1,2,3,4,5', 4),(10, '71,72,73,4,5', 4)
		  ,(11, '1,2,3,4,5', 5),(12, '1,2,3,4,5', 5)
		  ,(13, '1,2,3,4,5', 5),(14, '1,2,3,4,5', 5)
		  ,(15, '1,2,3,4,5', 6),(16, '1,2,3,4,5', 6)
		  ,(17, '1,2,3,4,5', 6),(18, '1,2,3,4,5', 6)
		  ,(19, '1,2,3,4,5', 7),(20, '1,2,3,4,5', 7)
		  ,(21, '1,2,3,4,5', 7),(22, '1,72,73,74,75', 7)
		  ,(23, '1,2,3,4,5', 8),(24, '1,2,3,4,5', 8)
		  ,(25, '1,2,3,4,5', 8),(26, '1,2,3,4,5', 8)
		  ,(27, '1,2,3,4,5', 9),(28, '1,2,3,4,5', 9)
		  ,(29, '1,2,3,4,5', 9),(30, '1,2,3,4,5', 9)
		  ,(65, '1,2,3,4,5', 10),(66, '1,2,3,4,5', 10)
		  ,(31, '1,2,3,4,5', 10),(32, '1,2,3,4,5', 10)
		  ,(33, '1,2,3,4,5', 11),(34, '1,2,3,4,5', 11)
		  ,(35, '1,2,3,4,5', 11),(36, '1,2,3,4,5', 11)
		  ,(37, '1,2,3,4,5', 12),(38, '1,2,3,4,5', 12)
		  ,(39, '1,2,3,4,5', 12),(40, '1,2,3,4,5', 12)
		  ,(41, '1,2,3,4,5', 13),(42, '1,2,3,4,5', 13)
		  ,(43, '1,2,3,4,5', 13),(44, '1,2,3,4,5', 13)
		  ,(45, '1,2,3,4,5', 14),(46, '1,2,3,4,5', 14)
		  ,(47, '1,2,3,4,5', 14),(48, '1,2,3,4,5', 14)
		  ,(49, '1,2,3,4,5', 15),(50, '1,2,73,74,75', 15)
		  ,(51, '1,2,3,4,5', 15),(52, '1,2,3,4,5', 15)
		  ,(53, '1,2,3,4,5', 16),(54, '1,2,3,4,5', 16)
		  ,(55, '1,2,3,4,5', 16),(56, '1,2,3,4,5', 16)
		  ,(57, '1,2,3,4,5', 17),(58, '1,2,3,4,5', 17)
		  ,(59, '1,2,3,4,5', 17),(60, '1,2,3,4,5', 17)
		  ,(61, '1,2,3,4,5', 18),(62, '1,2,3,4,5', 18)
		  ,(63, '1,2,3,4,5', 18),(64, '71,72,73,74,75', 18);
		  
INSERT INTO lottery.prizelevels(
            id, lotterydrawid, winningpercentage, level)
    VALUES (3, 3, 33, 1),(4, 3, 10, 2),
	(5, 3, 5, 3),(6, 3, 0, 4),
	(7, 3, 0, 5),(8, 3, 0, 6);
	
ALTER SEQUENCE lottery.lotterydraws_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.lotterygames_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.lotterytickets_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.operatorpermissionmap_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.operators_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.permissions_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.players_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.prizelevels_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.singleselections_id_seq INCREMENT BY 100;
ALTER SEQUENCE lottery.transactions_id_seq INCREMENT BY 100;