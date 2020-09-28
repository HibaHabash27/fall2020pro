Feature: Search about suitable home 

Background:
The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength) 
	Given  these homes are contained in the system 
		|HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
		|APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
		
#10. By type / Apartment, house		
Scenario Outline: Search home by type 
	When I search about home by <type> 
	Then A list of homes that matches the  type specification should be returned and printed on the console 
	Examples: 
		|type|
		|"house"|
		|"apartment"|
#3. By below specific price/ month		
Scenario: Search about home with less than a specific price 
	When I search about home with price less than 400 
	Then A list of homes that matches the price specification should be returned and printed on the console 
	
#1. By Placement/ City, Village	
Scenario Outline: Search home by placement 
	When i search about home by_placement <placement> 
	Then A list of homes that matches the  placement specification should be returned and printed on the console 
	Examples: 
		|placement|
		|"city"|
		|"village"|
#2. By Material/ Stone,Brick,Wood 		
Scenario Outline: Search home by material 
	When I search about home by_material <material> 
	Then A list of homes that matches the  material specification should be returned and printed on the console 
	Examples: 
		|material|
		|"stone"|
		|"brick"|
		|"wood"|

#7. By Number of bedrooms / 1,2,3,4,5	
Scenario Outline: Search home by number_of_bedroom 
	When I search about home by_number_of_bedroom <number_of_bedroom> 
	Then A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console 
	Examples: 
		|number_of_bedroom|
		|"1"|
		|"2"|
		|"3"|
		|"4"|
		|"5"|
#8. By Number of bathrooms/ 1,2,3		
Scenario Outline: Search home by number_of_bathroom 
	When I search about home by_number_of_bathroom <number_of_bathroom> 
	Then A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console 
	Examples: 
		|number_of_bathroom|
		|"1"|
		|"2"|
		|"3"|
		
#4. By between range of prices/ month
Scenario: Search home between range_of_prices 
	When I search about home between 200 and 500  
	Then A list of homes that matches the  range of price specification should be returned and printed on the console 
	



#5. By below specific area/ meter square	
Scenario: Search home below specific area 
	When I search home below area 400 
	Then A list of homes that matches the area specification should be returned and printed on the console 


#6. By between range of Areas/ meter square
Scenario: Search home between range_of_Areas
	When I search about home area between 200 and 500  
	Then A list of homes that matches the  range of area specification should be returned and printed on the console 
	
#9. By Allow Pets/ Yes, No
Scenario Outline: Search home by Allowing_pets
	When I search about home by_Alolowing pets <Allowed> 
	Then A list of homes that matches the  Allowing pets specification should be returned and printed on the console 
	Examples: 
		|Allowed|
		|"yes"|
		|"no"|

#11. By Lease Length / short term_6 months, long term_year
Scenario Outline: Search home by lease_Length
	When I search about home by lease length <lease_length> 
	Then A list of homes that matches the  lease length specification should be returned and printed on the console 
	Examples: 
		|lease_length|
		|"short"|
		|"long"|
#12. By Amenities/ AirConditioning, Balcony, Elevator, FirePlace, Garage Parking,
#Swimming Pool
Scenario Outline: Search home by Amenities
	When I search about home by Amenities <Amenities> 
	Then A list of homes that matches the  Amenities specification should be returned and printed on the console 
	Examples: 
		|Amenities|
		|"AirConditioning"|
		|"Elevator"|
		|"FirePlace"|
		|"Garage Parking"|
		|"Swimming Pool"|







#12. By Amenities/ AirConditioning, Balcony, Elevator, FirePlace, Garage Parking,
#Swimming Pool
#13. By Combination of at least 2 of the above mentioned scenarios		














