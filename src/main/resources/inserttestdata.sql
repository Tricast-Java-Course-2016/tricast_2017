-- password: asdf
INSERT INTO lottery.players(
            id, username, password, firstname, lastname, sex, identitycardnumber, 
            dob, country, zipcode, city, address, phonenumber, email, createddate)
    VALUES (1, 'player1', '$2a$10$v771qgBG7ng0npgoIhDfy.7T4CZFdmJtclx2yUzMAkmCZm3YpNKAa', 'John', 'Little', 0, '123456ab', 123, 'UK', '1234', 'London', 'Long St.', '+12 123 123 123', 'e@mail.com', '2016-12-12'),(2,'player2','asd222','Krisztián','Kovács',1,'123456ac',321,'US','New York','4321','Vertes St.','+12 123 321 321','es@gmail.com','2015-11-10');

-- password: asdf
INSERT INTO lottery.operators(
            id, username, password, firstname, lastname, sex, country, zipcode, 
            address, phonenumber, email, createdate)
    VALUES (1, 'operator1', '$2a$10$v771qgBG7ng0npgoIhDfy.7T4CZFdmJtclx2yUzMAkmCZm3YpNKAa', 'Thomas', 'Engine', 0, 'USA', '1234', 
            'Train Station', '-', 'ThomasThe@LittleGasEngine', '2016-12-31'),(2, 'operator2', 'dsa222', 'Tamas', 'Takacs', 0, 'Fr', '4321', 
            'Petofi Sandor', '-', 'TamasTakacs@gmail.com', '2017-02-11');

INSERT INTO lottery.transactions(
            id, type, amount, playerid, operatorid, createdate)
    VALUES (1, 'Withdraw', 1000, 1, 1, '2017-09-09'),(2, 'Withdraw', 3000, 2, 1, '2017-06-09');

INSERT INTO lottery.lotterygames(
            id, description, basestake, gridsize, numbersdrawn, nrofgrids, 
            minnroffox, maxnroffix, maxnrofcombination, createdate)
    VALUES (1, 'Ötös lottó', 500, 90, 5, 4, 
            1, 5, 4, '2015-03-30'),(2, 'Hatos lottó', 600, 60, 6, 4, 
            1, 5, 4, '2014-06-20');

INSERT INTO lottery.lotterydraws(
            id, basestake, gridsize, numbersdrawn, nrofgrids, minnroffox, 
            maxnroffix, maxnrofcombination, year, week, status, winningnumbers, 
            lotterygameid, createdate)
    VALUES (1, 500, 90, 5, 4, 1, 
            5, 4, '2017', 32, 'closed', '1,2,3,4,5', 
            1, '2017-09-05'),(2, 600, 70, 5, 4, 1, 
            5, 4, '2016', 32, 'closed', '1,2,3,4,5', 
            1, '2017-07-12');			

INSERT INTO lottery.lotterytickets(
            id, playerid, lotterydrawid, stake, fixnumbers, combinationnumbers, 
            createdate)
    VALUES (1, 1, 1, 500, 5, 0, 
            '2017-09-01'),(2, 2, 2, 500, 5, 0, 
            '2017-10-01');

INSERT INTO lottery.prizelevels(
            id, lotterydrawid, winningpercentage, level)
    VALUES (1, 1, 40, 3),(2, 2, 40, 3);

INSERT INTO lottery.singleselections(
            id, winningamount, selection, lotteryticketid, prizelevelid)
    VALUES (1, 4000, '1,2,3,4,6', 1, 1),(2, 6000, '1,2,3,4,6', 1, 1);


INSERT INTO lottery.operatorpermissionmap(
            id, operatorid, permissionid)
    VALUES (1, 1, 1),(2, 2, 2);

COMMIT		