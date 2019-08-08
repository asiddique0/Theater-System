JSF Web Pages:
1. MainPage.xhtml
- This page prompts the user for their zip code to query the database for theater locations.
2. zipLengthError.xhtml
- This error page is displayed when the zip code does not equal exactly 5 characters.
3. zipContentError.xhtml
- This error page is displayed when the input of 5 characters contains a non digit element.
4. theaterList.xhtml
- This page displays the list of theaters relevant to a zip code and allows the user to choose a theater.
5. movieList.xhtml
- This page displays the list of movies relevant to a theater and allows the user to choose a movie.
6. timingList.xhtml
- This page will display the selected movies information and will also list the available times for the user to select.
7. form.xhtml
- This page will ask the user to put in their relevant information to charge them for their purchase.
8. ccLengthError.xhtml
- This error page is displayed if the credit card length does not equal exactly 16 characters.
9. ccContentError.xhtml
- This error page is displayed if the credit card number contains a non digit character.
10. receipt.xhtml
- This page will show the user the information they entered and selected and display it as a receipt.
JSF Managed Beans:
1. MainPageBean.java
- Sets and validates the zip code.
2. TheaterList.java
- Gets the list of theaters in a zip code using an EJB and saves the user choice of theater.
3. MovieList.java 
- Gets the list of movies at a theater using an EJB and saves the user choice of movie.
4. TimingList.java
- Gets the list of timings of a movie for a theater using an EJB and saves the user choice of timing.
5. Form.java
- Gets the relevant user information such as credit card number and name and persists them to the database
  whilst checking for valid input.
6. Receipt.java
- Gets the user selected information and displays them to the user in the form of a receipt.
EJB:
1. theaterEJB.java
- Queries the database for the JSF Managed Beans to obtain the relevant information such as a list of movies/theaters/etc.
Entity:
1. Location.java
- Where the Location data is obtained from through the entity manager.
2. Movie.java
- Representative of the Movie table containing the relevant information.
3. Paymenttable.java
- Used to persist the payment information to the relevant data table.
4. Theater.java
- Similiar to Movie.java.
5. Timing.java
- Similar to Movie.java
6. TimingPK.java
- Contains the primary key objects of the Timing.java entity.
