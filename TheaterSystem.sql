-- All the SQL to set up the database
create table Location(
	zip varchar(9),
	stateabr char(2) not null,
	country varchar(50),
	constraint pkLocation primary key (zip)
);

create table Theater(
	theater_name varchar(100),
	theater_address varchar(250),
	zip varchar(9),
	constraint pkTheater primary key 
		(theater_name),
	constraint fkLocation foreign key (zip)
		references Location(zip)
);

create table Movie(
	movie_name varchar(100),
	movie_description varchar(1000),
	movie_type varchar(20),
	movie_rating varchar(20),
	movie_runtime int not null,
	movie_image varchar(20),
	constraint greaterThanZero
		check (movie_runtime > 0),
	constraint pkMovie primary key
		(movie_name)
);

create table Timing(
	theater_name varchar(100),
	movie_name varchar(100),
	movie_time time not null,
	constraint pkTiming primary key 
		(theater_name, movie_name, movie_time),
	constraint fkTheater foreign key (theater_name)
		references Theater(theater_name),
	constraint fkMovie foreign key (movie_name)
		references Movie(movie_name)
);

create table Theater_Movie(
	theater_name varchar(100),
	movie_name varchar(100),
	constraint pkTheater_movie primary key (theater_name, movie_name),
	constraint fkTheater_Movie foreign key (theater_name)
		references Theater(theater_name),
	constraint fkMovie_Theater foreign key (movie_name)
		references Movie(movie_name)
);

create table PaymentTable(
	transaction_id varchar(1000),
	customer_name varchar(100),
	customer_phone varchar(20),
	card_number char(16) not null,
	cvv char(3) not null,
	transaction_date date not null,
	constraint pkPaymentTable primary key (transaction_id)
	);


-- Insert into Location
insert into Location values (
	'75081', 'TX', 'United States of America');

insert into Location values (
	'73134', 'OK', 'United States of America');
	
insert into Location values (
	'08807', 'NJ', 'United States of America');
	
-- Insert into Theater
-- 75081 (Richardson, TX)
insert into Theater values (
	'AMC Firewheel 18', '100 Coneflower Drive Garland', '75081');
	
insert into Theater values (
	'AMC Valley View 16', '13331 Preston Rd Ste 2300 Dallas', '75081');
	
insert into Theater values (
	'Village On The Parkway 9', '5100 Belt Line Rd, Ste 220 Addison', '75081');

-- 73134 (OKC, OK)
insert into Theater values (
	'AMC Quail Springs Mall 24', '2501 W. Memorial Rd Suite EOklahoma City', '73134');
	
insert into Theater values (
	'AMC CLASSIC Northpark 7', '12100 N May Ave. Ste. G Oklahoma City', '73134');

-- 08807 (Bridgewater, NJ)
insert into Theater values (
	'AMC DINE-IN Bridgewater 7', '400 Commons Way Ste 380 Bridgewater', '08807');

-- Insert into Movie
insert into Movie values (
	'Spider-Man: Far From Home', 
	'Following the events of Avengers: Endgame, Spider-Man must step up to take on new threats in a world that has changed forever.',
	'Action',
	'PG-13',
	130,
	'SpiderManFFH.jpg'
);

insert into Movie values (
	'Toy Story 4',
	'Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that''s Andy or Bonnie. But when Bonnie adds a reluctant new toy called ''Forky'' to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.',
	'Animation',
	'G',
	100,
	'ToyStory4.jpg'
);

insert into Movie values (
	'Aladdin',
	'A thrilling and vibrant live-action adaptation of Disney’s animated classic, “Aladdin” is the exciting tale of the charming street rat Aladdin, the courageous and self-determined Princess Jasmine and the Genie who may be the key to their future.',
	'Adventure',
	'PG',
	129,
	'Aladdin.jpg'
);

insert into Movie values (
	'The Lion King',
	'Disney''s upcoming film journeys to the African savanna where a future king is born. Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub''s arrival. Scar, Mufasa''s brother--and former heir to the throne--has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba''s exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his. The all-star cast includes Donald Glover as Simba, Beyonce Knowles-Carter as Nala, James Earl Jones as Mufasa, Chiwetel Ejiofor as Scar, Seth Rogen as Pumbaa and Billy Eichner as Timon, and utilizes pioneering filmmaking techniques to bring treasured characters to life in a whole new way.',
	'Adventure',
	'PG',
	118,
	'TheLionKing.jpg'
);

insert into Movie values (
	'Men In Black International',
	'The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.',
	'Science Fiction',
	'PG-13',
	115,
	'MIBI.jpg'
);

insert into Movie values (
	'Midsommar',
	'Dani and Christian are a young American couple with a relationship on the brink of falling apart. But after a family tragedy keeps them together, a grieving Dani invites herself to join Christian and his friends on a trip to a once-in-a-lifetime midsummer festival in a remote Swedish village. What begins as a carefree summer holiday in a land of eternal sunlight takes a sinister turn when the insular villagers invite their guests to partake in festivities that render the pastoral paradise increasingly unnerving and viscerally disturbing. From the visionary mind of Ari Aster comes a dread-soaked cinematic fairytale where a world of darkness unfolds in broad daylight.',
	'Horror',
	'R',
	147,
	'Midsommar.jpg'
);

-- Insert into Theater_Movie for AMC Firewheel 18
insert into Theater_Movie values (
	'AMC Firewheel 18', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'AMC Firewheel 18', 'Toy Story 4'
);

insert into Theater_Movie values (
	'AMC Firewheel 18', 'Aladdin'
);

insert into Theater_Movie values (
	'AMC Firewheel 18', 'The Lion King'
);

insert into Theater_Movie values (
	'AMC Firewheel 18', 'Men In Black International'
);

insert into Theater_Movie values (
	'AMC Firewheel 18', 'Midsommar'
);


-- Insert into Timing for AMC Firewheel 18 for Spider-Man: Far From Home
insert into Timing values (
	'AMC Firewheel 18', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'AMC Firewheel 18', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'AMC Firewheel 18', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for AMC Firewheel 18 for Toy Story 4
insert into Timing values (
	'AMC Firewheel 18', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'AMC Firewheel 18', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'AMC Firewheel 18', 'Toy Story 4', '18:30'
);

-- Insert into Timing for AMC Firewheel 18 for Aladdin
insert into Timing values (
	'AMC Firewheel 18', 'Aladdin', '12:45'
);

insert into Timing values (
	'AMC Firewheel 18', 'Aladdin', '15:45'
);

insert into Timing values (
	'AMC Firewheel 18', 'Aladdin', '18:45'
);

-- Insert into Timing for AMC Firewheel 18 for The Lion King
insert into Timing values (
	'AMC Firewheel 18', 'The Lion King', '13:00'
);

insert into Timing values (
	'AMC Firewheel 18', 'The Lion King', '16:00'
);

insert into Timing values (
	'AMC Firewheel 18', 'The Lion King', '19:00'
);

-- Insert into Timing for AMC Firewheel 18 for Men In Black International
insert into Timing values (
	'AMC Firewheel 18', 'Men In Black International', '13:15'
);

insert into Timing values (
	'AMC Firewheel 18', 'Men In Black International', '16:15'
);

insert into Timing values (
	'AMC Firewheel 18', 'Men In Black International', '19:15'
);

-- Insert into Timing for AMC Firewheel 18 for Midsommar
insert into Timing values (
	'AMC Firewheel 18', 'Midsommar', '13:30'
);

insert into Timing values (
	'AMC Firewheel 18', 'Midsommar', '16:30'
);

insert into Timing values (
	'AMC Firewheel 18', 'Midsommar', '19:30'
);


-- Insert into Theater_Movie for AMC Valley View 16
insert into Theater_Movie values (
	'AMC Valley View 16', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'AMC Valley View 16', 'Toy Story 4'
);

insert into Theater_Movie values (
	'AMC Valley View 16', 'Aladdin'
);

insert into Theater_Movie values (
	'AMC Valley View 16', 'The Lion King'
);

insert into Theater_Movie values (
	'AMC Valley View 16', 'Men In Black International'
);

insert into Theater_Movie values (
	'AMC Valley View 16', 'Midsommar'
);


-- Insert into Timing for AMC Valley View 16 for Spider-Man: Far From Home
insert into Timing values (
	'AMC Valley View 16', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'AMC Valley View 16', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'AMC Valley View 16', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for AMC Valley View 16 for Toy Story 4
insert into Timing values (
	'AMC Valley View 16', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'AMC Valley View 16', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'AMC Valley View 16', 'Toy Story 4', '18:30'
);

-- Insert into Timing for AMC Valley View 16 for Aladdin
insert into Timing values (
	'AMC Valley View 16', 'Aladdin', '12:45'
);

insert into Timing values (
	'AMC Valley View 16', 'Aladdin', '15:45'
);

insert into Timing values (
	'AMC Valley View 16', 'Aladdin', '18:45'
);

-- Insert into Timing for AMC Valley View 16 for The Lion King
insert into Timing values (
	'AMC Valley View 16', 'The Lion King', '13:00'
);

insert into Timing values (
	'AMC Valley View 16', 'The Lion King', '16:00'
);

insert into Timing values (
	'AMC Valley View 16', 'The Lion King', '19:00'
);

-- Insert into Timing for AMC Valley View 16 for Men In Black International
insert into Timing values (
	'AMC Valley View 16', 'Men In Black International', '13:15'
);

insert into Timing values (
	'AMC Valley View 16', 'Men In Black International', '16:15'
);

insert into Timing values (
	'AMC Valley View 16', 'Men In Black International', '19:15'
);

-- Insert into Timing for AMC Valley View 16 for Midsommar
insert into Timing values (
	'AMC Valley View 16', 'Midsommar', '13:30'
);

insert into Timing values (
	'AMC Valley View 16', 'Midsommar', '16:30'
);

insert into Timing values (
	'AMC Valley View 16', 'Midsommar', '19:30'
);


-- Insert into Theater_Movie for Village On The Parkway 9
insert into Theater_Movie values (
	'Village On The Parkway 9', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'Village On The Parkway 9', 'Toy Story 4'
);

insert into Theater_Movie values (
	'Village On The Parkway 9', 'Aladdin'
);

insert into Theater_Movie values (
	'Village On The Parkway 9', 'The Lion King'
);

insert into Theater_Movie values (
	'Village On The Parkway 9', 'Men In Black International'
);

insert into Theater_Movie values (
	'Village On The Parkway 9', 'Midsommar'
);


-- Insert into Timing for Village On The Parkway 9 for Spider-Man: Far From Home
insert into Timing values (
	'Village On The Parkway 9', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'Village On The Parkway 9', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'Village On The Parkway 9', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for Village On The Parkway 9 for Toy Story 4
insert into Timing values (
	'Village On The Parkway 9', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'Village On The Parkway 9', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'Village On The Parkway 9', 'Toy Story 4', '18:30'
);

-- Insert into Timing for Village On The Parkway 9 for Aladdin
insert into Timing values (
	'Village On The Parkway 9', 'Aladdin', '12:45'
);

insert into Timing values (
	'Village On The Parkway 9', 'Aladdin', '15:45'
);

insert into Timing values (
	'Village On The Parkway 9', 'Aladdin', '18:45'
);

-- Insert into Timing for Village On The Parkway 9 for The Lion King
insert into Timing values (
	'Village On The Parkway 9', 'The Lion King', '13:00'
);

insert into Timing values (
	'Village On The Parkway 9', 'The Lion King', '16:00'
);

insert into Timing values (
	'Village On The Parkway 9', 'The Lion King', '19:00'
);

-- Insert into Timing for Village On The Parkway 9 for Men In Black International
insert into Timing values (
	'Village On The Parkway 9', 'Men In Black International', '13:15'
);

insert into Timing values (
	'Village On The Parkway 9', 'Men In Black International', '16:15'
);

insert into Timing values (
	'Village On The Parkway 9', 'Men In Black International', '19:15'
);

-- Insert into Timing for Village On The Parkway 9 for Midsommar
insert into Timing values (
	'Village On The Parkway 9', 'Midsommar', '13:30'
);

insert into Timing values (
	'Village On The Parkway 9', 'Midsommar', '16:30'
);

insert into Timing values (
	'Village On The Parkway 9', 'Midsommar', '19:30'
);


-- Insert into Theater_Movie for AMC Quail Springs Mall 24
insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'Toy Story 4'
);

insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'Aladdin'
);

insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'The Lion King'
);

insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'Men In Black International'
);

insert into Theater_Movie values (
	'AMC Quail Springs Mall 24', 'Midsommar'
);


-- Insert into Timing for AMC Quail Springs Mall 24 for Spider-Man: Far From Home
insert into Timing values (
	'AMC Quail Springs Mall 24', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for AMC Quail Springs Mall 24 for Toy Story 4
insert into Timing values (
	'AMC Quail Springs Mall 24', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Toy Story 4', '18:30'
);

-- Insert into Timing for AMC Quail Springs Mall 24 for Aladdin
insert into Timing values (
	'AMC Quail Springs Mall 24', 'Aladdin', '12:45'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Aladdin', '15:45'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Aladdin', '18:45'
);

-- Insert into Timing for AMC Quail Springs Mall 24 for The Lion King
insert into Timing values (
	'AMC Quail Springs Mall 24', 'The Lion King', '13:00'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'The Lion King', '16:00'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'The Lion King', '19:00'
);

-- Insert into Timing for AMC Quail Springs Mall 24 for Men In Black International
insert into Timing values (
	'AMC Quail Springs Mall 24', 'Men In Black International', '13:15'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Men In Black International', '16:15'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Men In Black International', '19:15'
);

-- Insert into Timing for AMC Quail Springs Mall 24 for Midsommar
insert into Timing values (
	'AMC Quail Springs Mall 24', 'Midsommar', '13:30'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Midsommar', '16:30'
);

insert into Timing values (
	'AMC Quail Springs Mall 24', 'Midsommar', '19:30'
);


-- Insert into Theater_Movie for AMC CLASSIC Northpark 7
insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'Toy Story 4'
);

insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'Aladdin'
);

insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'The Lion King'
);

insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'Men In Black International'
);

insert into Theater_Movie values (
	'AMC CLASSIC Northpark 7', 'Midsommar'
);


-- Insert into Timing for AMC CLASSIC Northpark 7 for Spider-Man: Far From Home
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for AMC CLASSIC Northpark 7 for Toy Story 4
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Toy Story 4', '18:30'
);

-- Insert into Timing for AMC CLASSIC Northpark 7 for Aladdin
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Aladdin', '12:45'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Aladdin', '15:45'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Aladdin', '18:45'
);

-- Insert into Timing for AMC CLASSIC Northpark 7 for The Lion King
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'The Lion King', '13:00'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'The Lion King', '16:00'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'The Lion King', '19:00'
);

-- Insert into Timing for AMC CLASSIC Northpark 7 for Men In Black International
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Men In Black International', '13:15'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Men In Black International', '16:15'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Men In Black International', '19:15'
);

-- Insert into Timing for AMC CLASSIC Northpark 7 for Midsommar
insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Midsommar', '13:30'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Midsommar', '16:30'
);

insert into Timing values (
	'AMC CLASSIC Northpark 7', 'Midsommar', '19:30'
);


-- Insert into Theater_Movie for AMC DINE-IN Bridgewater 7
insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'Spider-Man: Far From Home'
);

insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'Toy Story 4'
);

insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'Aladdin'
);

insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'The Lion King'
);

insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'Men In Black International'
);

insert into Theater_Movie values (
	'AMC DINE-IN Bridgewater 7', 'Midsommar'
);


-- Insert into Timing for AMC DINE-IN Bridgewater 7 for Spider-Man: Far From Home
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Spider-Man: Far From Home', '12:00'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Spider-Man: Far From Home', '15:00'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Spider-Man: Far From Home', '18:00'
);

-- Insert into Timing for AMC DINE-IN Bridgewater 7 for Toy Story 4
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Toy Story 4', '12:30'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Toy Story 4', '15:30'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Toy Story 4', '18:30'
);

-- Insert into Timing for AMC DINE-IN Bridgewater 7 for Aladdin
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Aladdin', '12:45'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Aladdin', '15:45'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Aladdin', '18:45'
);

-- Insert into Timing for AMC DINE-IN Bridgewater 7 for The Lion King
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'The Lion King', '13:00'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'The Lion King', '16:00'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'The Lion King', '19:00'
);

-- Insert into Timing for AMC DINE-IN Bridgewater 7 for Men In Black International
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Men In Black International', '13:15'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Men In Black International', '16:15'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Men In Black International', '19:15'
);

-- Insert into Timing for AMC DINE-IN Bridgewater 7 for Midsommar
insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Midsommar', '13:30'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Midsommar', '16:30'
);

insert into Timing values (
	'AMC DINE-IN Bridgewater 7', 'Midsommar', '19:30'
);