# Project Plan



**Author**: CSCI 370 Spring 21 Section 34 Team 6

## 1 Introduction



An application that allows users to create multiple grocery lists, where one can add grocery items and have each checked off at any given time. 

## 2 Process Description



#### MainActivity -> HomeFragment
- Upon entrance to MainActivity, it will redirect users to HomeFragment since we have decided to go with Fragments implementation instead of Activities for smoother user experience.
- The HomeFragment will display all the Grocery Lists that are available. Also allows user to add, edit, merge, or delete any lists.
- No **Entrance criteria**
- No **Exit criteria**

#### NewListFragment
- Allows the user to enter name and description about a new GroceryList they are trying to create. If a GroceryList is provided upon entrance, the user can edit the list name.
- Entrance criteria: Pressing on **New List** button
- Exit criteria: if **successful**, returns a GroceryList object

#### GroceryListFragment
- Displays all the items in the GroceryList. Allows user to search, filter, or filter items. 
- **Mandatory** Entrance criteria: GroceryList object
- No **Exit criteria**

#### SearchFragment
- Allows the user to search for the list of items that are available to add to cart. Can filter/search based on requirements When item is desired, upon clicking the *+* button, a pop up will appear to enter quantity and which GroceryList to add to. 
- Entrance criteria: 
    - First method: Press on GroceryList object and press on **Add New Item**
    - Second method: Press on **Search** icon on Navbar 
- Exit criteria: if **successful**, returns a GroceryListItem where itemTypes are displayed in a table

#### SettingsFragment
- Allows user to customize the app‘s UI and theme, as well as conditions on terms and COVID related informations.
- Entrance criteria: Press on **Setting** icon on Navbar
- Exit criteria: Press on **Back** button will bring user back to HomeFragment

#### SearchTypeFragment
- Displays all items that belongs to the specified itemType.
- Allows user to select an item from the specified itemType.
- Entrance criteria: Press on an Item object
- Exit criteria: 
    - Pressing **Back** button will bring user back to SearchFragment
    - Pressing **Done** button will bring user back to GroceryListFragment, as well as item added to selected grocery list

#### AddItemFragment
- Allows users to select quantity of a specific item from to add into any grocery list via a drop down spinner. 
- Entrance criteria: Press on an Item object from SearchTypeFragment
- Exit criteria: 
    - Pressing **Cancel** button will bring user back to SearchFragment
    - Pressing **Add** button will bring user to SearchTypeFragment, and item added to specified grocery list 

#### EditItemFragment
- Allows users to edit quantity of a specific item in the specified grocery list. This also allows user to move the item from current list to another list.
- Entrance criteria: Pressing on **Cogwheel** icon in any grocery list
- Exit criteria:
    - Pressing **Cancel** button will bring user back to GroceryListFragment
    - Pressing **Save** button will bring user back to GroceryListFragment with quantity updated
    - Pressing **Delete** button will bring user back to GroceryListFragment with item deleted

#### AddItemtoDBFragment
-  Should an item not exist in the database for retrieval, the user is prompted for an item name and type along with a picture. If a picture is not selected, the picture for the item type is defaulted to. 
- Entrance criteria: Pressing on **New Item** button in SearchFragment 
- Exit criteria:
    - Pressing **Add Item** button will bring user back to SearchFragment with the new item added into the selected item type 
    - Pressing **Cancel** button will bring user back to SearchFragment

    
## 3 Team

|Name| Role|
|---|----|
|Bakhtiyorjon Rasulov|Frontend|
|Patricio Tapia|Backend|
|Daniel Rodriguez|Database|
|Pravesh Tilija|QA|
|Oscar Lui|Team Manager|

- Team Manager: In charge of the project overview along with assisting other roles.
- Frontend: In charge of the visual aspect of the application.
- Backend: In charge of connecting the database with the frontend, and making sure requests and data are sent both ways.
- Database: In charge of creation of tables and retrival of data through queries.
- QA: In charge of test cases to ensure bugs are dealt with.

Members of the team will assist each other depending on the priority of which part of the application needs to be implemented first.
- This allows for everyone to learn what each role does with practical experience.
