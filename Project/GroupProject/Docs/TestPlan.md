# Test Plan

**Author**: CSCI 370 Spring 21 Section 34 Team 6

## 1 Testing Strategy

### 1.1 Overall strategy

Since this application consists of a simple system, testing strategy will be kept simple

- Manual testing: Mainly executed by our QA tester. Also performing black-box testing and white-box testing to catch and fix bugs.
- Unit testing: Individual units or components of code will be tested.
- Integration testing: Test will involve how multiple components mash with one another.
- System Testing: Testing as a complete and fully integrated app and evaluate the requirements.
- Regression testing: Should there be changes/adaptations in terms of implementations, prior tests will be re-ran to see if components are still functioning.

### 1.2 Test Selection

We will be using black-box testing to test each of the internal components to make sure that they are functioning correctly. White-box testing will be performed for each individual function.


- Unit testing: white-box (Control Flow & Statement Coverage)
- Integration testing: white-box (Control Flow & Branch Coverage) / black-box
- System testing: black-box (Error Guessing & Functional Testing)
- Regression testing: black-box (Error Guessing & Functional Testing)

### 1.3 Adequacy Criterion

Test cases should be documented thoroughly, as small units without combining as much functional parts.

Since we are implementing custom class objects with a supplied input to the methods testing, we will know what the expected output should be. There will hence be two sets of tests.

- Testing the validity of data at object creation or modification
- Testing for bad data types supplied to methods or constructors to assess any error catching

### 1.4 Bug Tracking

As we go through unit tests, we will mark down in a table whether that specific test cases has passed or failed. Developers will be able to look at the table the determine their functionality and what needs to be modified to fix them. When a failed test cases is flagged at build time, we will take note of the unit that failed and will create a task to address that unit to our team.

### 1.5 Technology

We will be utilizing **JUnit** for manual testing.

We will always test for regression everytime we modify a class. This is to ensure that when an old test fails, we will know which modification affected the failed unit and address the error accordingly.

## 2 Test Cases

For each test case row, we will describe them in the following columns:

1. Test Case
2. Activity in which the unit resides
3. Purpose of the test
4. Procedure
5. Input required
6. Expected result
7. Actual result
8. Status (passed or failed)


| Test Case | Test Source  | Purpose | Procedure | Input | Expected result | Actual result | Pass/Fail| 
| -------- | -------- | -------- |------- |-------- | -------- | ------- | ------ |
| Start application     | None     | Test that the application opens    | Open the application on your device    | None | User is in HomeFragment | User is in HomeFragment | Pass
| Create List Button    | HomeFragment  | The user is able to create a list     | Press the "NEW LIST" button     | "NEW LIST" button pressed     | Brings user to NewListFragment     | Brings user to NewListFragment | Pass
| Input List Name    | NewListFragment  | The user is able to input a name for the list     | Press on "Enter List Name" field and insert name   | String     | Name of list should be displayed     | Name of list displayed| Pass
| Add to list Button    | NewListFragment  | The user is able to add the list onto GroceryListManager     | Press the "ADD LIST " button   | "ADD LIST" button pressed   | Brings user to GroceryListFragment     | Brings user to GroceryListFragment| Pass
| Cancel Button    | NewListFragment  | The user is able to cancel the creation of a new list   | Press "CANCEL" button   | "CANCEL" button pressed   | Bring user back to HomeFragment  | Bring user back to HomeFragment| Pass
| Rename List     | GroceryListFragment  | The user is able to rename a list     | Select the list by pressing the checkbox and press the "RENAME" button, and provide a string input to text field     | String     | List is renamed | List is renamed| Pass
| Select List     | HomeFragment  | The user is able to select a list     | Select the List by pressing the checkbox    | None     | Brings user to GroceryListFragment | Brings user to GroceryListFragment| Pass
| Delete List     | HomeFragment  | The user is able to delete a list     | User selects the list by pressing the checkbox and presses on the "DELETE" button     | Radio button(s) selected    |List is deleted and no longer visible in HomeFragment  | List is deleted and no longer visible in HomeFragment| Pass
| Merge List | HomeFragment | The user is able to merge two or more lists into one |User checks two or more lists and presses the "MERGE" button  |"Merge" button pressed | Two or more lists are merged into just one list | Two or more lists are merged into just one list| Pass
| Search Item Button   | GroceryListFragment     | The user is able to search an item from items grouped by type    | User presses the "ADD NEW ITEM" button     | "ADD NEW ITEM" button is pressed     |App is redirected to the SearchFragment    | App is redirected to the SearchFragment| Pass
| Search Item Button (Navbar)  | In every Fragment     | The user is able to search an item from any Fragment    | User presses the search icon on the navigation bar     | search icon button is pressed     |App is redirected to the SearchFragment    | App is redirected to the SearchFragment | Pass
| Add Item     | SearchFragment     | The user is able to add an item to a list    | User presses one of the item types at SearchFragment, selects item and presses the "ADD" button     | "ADD" button is pressed     |Item is added to a list    | Item is added to a list| Pass
| Cancelling the Add Item pop-up     | SearchFragment     | The user is able to cancel the add item procedure    | User presses one of the item types at SearchFragment, selects item and presses the "CANCEL" button     | "CANCEL" button is pressed     | Brings user back to SearchFragment     | Brings user back to SearchFragment| Pass
| Delete Item   | GroceryListFragment  | The user is able to delete an item from a list     | User selects the item and presses the gear icon button at GroceryListFragment and presses the "DELETE" button    | Item(s) are selected and "DELETE" button is pressed     |Item(s) are deleted and no longer visible in the list  | Item(s) are deleted and no longer visible in the list| Pass
| Check off Item  | GroceryListFragment   | The user is able to check off an item     | User presses the checkbox of an item at GroceryListFragment     | Checkbox is checked      |Item is checked off(not selected)     | Item is checked off(not selected)| Pass
| Clear all checks  | GroceryListFragment     | The user is able to clear off all checks     | User presses the "CLEAR ALL" button at GroceryListFragment     | "CLEAR ALL" button is pressed     |All item(s) are checked off(not selected)    | All item(s) are checked off(not selected)| Pass
| Set Quantity  | GroceryListFragment   | The user is able to set a quantity to an item     | User presses the gear icon of an item and changes the quantity with a '-' or '+' button   | '-' or '+' button is pressed     |The quantity of the item is set/changed    | The quantity of the item is set/changed| Pass
| Group Items  | GroceryListFragment  | The user is able to group items by itemType alphabetically    | Press "filter" button and select group by type     | "filter" button pressed and group by type selected   |Items are grouped together   | Yet to be implemented| Fail
| Create Item Button    | SearchFragment   | The user is able to create an item     | Press the Create button  | Create button pressed   |Brings user to AddItemtoDBFragment    | User is brought to AddItemtoDBFragment | Pass
| Input Item Name  | AddItemtoDBFragment   | The user is able to type the item name   | Press on item name field and insert name    | String     | Name of item should be displayed  | Item name is displayed | Pass
| Input ItemType Name  | AddItemtoDBFragment   | The user is able select the itemType    | Press on itemType dropdown spinner and select itemType    | itemType is pressed   |Name of itemType should be displayed     | Name of itemType displayed | Pass
| Add to Warehouse Button | AddItemtoDBFragment   | The user is able to add the item into the warehouse    | Press the "Add" button   | "Add" button pressed    |Item is created and added into DB   | Item is created and added into DB | Pass
| Cancel Button  | AddItemtoDBFragment   | The user is able to cancel the action    | Press the "Cancel" button    | "Cancel" button pressed   | Brings user back to SearchFragment   | User is brought back to SearchFragment| Pass
| Home Button (navbar) | In every Activity   | The user is able to return back to GroceryListManager(HomeFragment)    | Press the "Home" button    | "Home" button pressed   | Brings user back to HomeFragment  |Brings user back to HomeFragment| Pass
