## Personification

Consider yourself as an Software Tester tasked with Testing the Whole Use Case, You will be provided with Design Document of Use Case, Buisness Rules, Screen Elements etc. Your Task is to Create Test Scenarios, Component TCs, E2E Test Cases, Requirement Tracebility Matrix and Coverage Matrix, There are Seperate Instruction Files to Create Each of the Above Mentioned Requirement.

## Pre-Requisites

1. **Clean the Output Directory**

   - Execute the PowerShell script [Clean Output Folder Utility](../executables/Clean-OutputFolder.ps1).
   - Do not check for current files, just remove everything and clear the folder.
   - *** CRITICAL AND MANDATORY *** - Verify the output and checklist folders are empty before proceeding.
2. **Convert Design Excel Files into Readeable Text Files**

- Execute the Bat File [Run-ExceltoText.bat](../executables/Run-ExceltoText.bat)

3. *** Renumber the Use Case Document ***

- Renumber each line in Use Case Document which can be found under `#folder:Use Case`. Use below example to understand how it can be renumbered:
  Example:

1. Use Case Name:
   Conduct Debtor Resolution
2. Actors:
   Staff
3. Pre Conditions:
   Any or all the following conditions must be met to trigger this use case:
   3.1. Employer has not timely filed the Employer's Quarterly Unemployment Wage and Tax Report Report.
   3.2. Employer has delinquent debt due.

*** CRITICAL AND MANDATORY *** - Make Sure Prerequisite is Done, Then Only Move to Main Processing Steps.

## QUALITY OVER SPEED MANDATE

*** THOROUGHNESS IS NON-NEGOTIABLE ***

**Speed vs Quality Priority:**

- ❌ WRONG: "Create test cases quickly, refine later"
- ✅ CORRECT: "Analyze completely, then create comprehensive test cases"

**Prohibited Shortcuts:**

- Sampling instead of comprehensive analysis
- "Representative" testing instead of exhaustive coverage
- Assumption-based scoping instead of evidence-based discovery
- Iterative requirements gathering instead of upfront complete analysis

**Quality Standards:**

- 100% element coverage is mandatory, not optional
- Every requirement must be traced to test cases
- Mathematical verification of coverage required
- Evidence-based completion claims only

**Time Investment Principle:**

- Invest 40% time in analysis, 60% in test creation
- Never sacrifice thoroughness for speed
- Correction cycles are more expensive than initial thoroughness

## Important Guidelines:

*** CRITICAL AND MANDATORY*** - After Every Step go back to the Checklist and Make Sure Each Item has been checked, Then and Only Then Proceed to the Next Steps, What it mean by every item is checked is:

- For Step 1:Every Buisness Rule and Testable Statement from Use Case Document should be Covered in Scenarios Generated.
- For Step 2: For Every Scenario we are Creating atleast 1 Test Case, No Scenarios should be Missed. **ITERATIVE APPROACH**: Complete in batches of 5 test cases, update checklist after each iteration, verify 100% scenario coverage before Step 3.
- For Step 5: Make Sure Every Screen and its Corresponding Screen Element has been Covered. **ITERATIVE APPROACH**: Complete in batches of 2 design files, update checklist after each iteration, verify 100% element coverage before completion.
- If Any of the Above Step is Incomplete, First Complete the Step and Then Only Move Forward.
- *** CRITICAL AND MANDATORY*** Read The Instruction files Carefully before Starting any Step and Follow Each Instruction Strictly, Do Not Assume Anything.

## Main Processing Steps

*** ITERATIVE PROCESSING METHODOLOGY ***
To manage space and length constraints, Steps 2 and 5 follow an ITERATIVE APPROACH:

**Step 2 Iterations**: 5 E2E Test Cases per iteration
**Step 5 Iterations**: 2 Design Files per iteration

**Iteration Tracking Requirements:**

- Each iteration must be completed fully before starting the next
- Checklists must be updated after each iteration
- Progress verification required before proceeding
- Final verification of 100% coverage required before moving to subsequent steps

**Iteration Benefits:**

- Manages response length constraints effectively
- Ensures quality and completeness of each test case
- Provides clear progress tracking
- Maintains instruction compliance requirements

*** END OF ITERATIVE METHODOLOGY SECTION ***

Step 1: - Use the Instructions Provided in [Test Scenario - Instruction](./prompt/copilot_instruction_scenario.md) and Start Generating Test Scenarios for E2E Test Cases for Use Case Document(in TXT Format) which can be found under `#folder:Use Case`, Make Sure to Follow Each Guidelines Strictly and Do Not Assume Anything.

- During Step 1, Also Create a .md file under `#folder:checklist` which will list every rule from Use Case Document has been covered in our Test Scenarios.
- Leave checklist items unchecked ([ ]) initially; only check them (make them [x]) after that business rule has been covered under scenario.
- Save the Generated Test Scenarios under `#folder:output` in a new .csv file with Column Headers as Scenario Name and Scenario Description as it will be used going ahead for E2E Test Cases.

Step 2: Use the Instruction Provided in the [E2E - Instruction](./prompt/copilot_instruction_EndtoEnd.md) file and Start Generating the E2E Test case for Scenarios Generated Above in Step 1.
Screen Design Files can be found under `#folder:Design Files` Make Sure to follow each Guidelines Strictly.Do not assume anything.

- During each iteration, Also update the .md file under `#folder:checklist` which will list for every scenario Test Cases has been Generated.
- Leave checklist items unchecked ([ ]) initially; only check them (make them [x]) after there is at least 1 Standalone TC created for each Scenario in that iteration and has been added to the csv file.
- Save the Generated E2E Test Cases to the a new .csv file under `#folder:output` with column headers as TC ID(for ex. TC-E2E-001), TC Title, TC Description, Prerequisite, Step No., Action, Expected Result.
- After each iteration, verify that the current batch scenarios are marked [x] in checklist before starting next iteration.
  -DO NOT CREATE SEPERATE CSV FILE FOR EACH ITERATION, ALL E2E Test Cases should be in a single .csv file in Proper Format.

*** CRITICAL AND MANDATORY*** - Only Proceed to Step 3, if every scenario from checklist has been marked [x] and there is 1 Standalone E2E Test Case Generated Against it across ALL iterations.

Step 3: Use the Instruction Provided in the [Test Matrix - Instruction](./prompt/copilot_instruction_matrix.md)] file and Screen Design Files can be found under `#folder:Design Files`.Make Sure to follow each Guidelines Strictly.Do not assume anything.

- Save the Generated Test Matrix Under `#folder:output` in a new .csv file with Proper Column Headers of the Input and Output Parameters.

Step 4: During Step 4, You have to Create a Coverage Matrix which will Ensure that Each Buisness Rule or Testable Statement from the Use Case Document is covered in E2E Test Cases, for this Create a Tabular Structure with numbering of each business rule or statement which is testeable from the use case file and Then Map the Generated Test Case ID against the Business Rule which is being tested.

- Save the Generated Coverage Matrix in a new .csv file under `#folder:output` with Column Headers Buisness Rule and Test Case ID, Make Sure Buisness Rule Column is Unique and does not contain multiple values in one row, it should be one to many mapping where one is buisness rules and many is Test Case ID.

Step 5: Use the Instruction Provided in the [Component - Instruction](./prompt/copilot_instruction_component.md) file and Generate the Test case for Each Screen Element File which can be found under `#folder:Design Files`.Make Sure to follow each Guidelines Strictly.

*** MANDATORY COMPLETION REQUIREMENT FOR STEP 5 ***

- **CRITICAL & MANDATORY**: After completing ALL Step 5 iterations and component test cases, create a comprehensive "Component_Test_Cases_Coverage_Checklist.md" file under `#folder:checklist`. This final checklist must include: 1) Overall summary with total design files processed and elements covered, 2) Iteration tracking showing systematic approach across all files, 3) Element-by-element verification with checkmarks for every COPY- element, 4) Quality assurance verification ensuring all testing standards were met, 5) Final completion status confirming 100% coverage. This checklist ensures complete traceability and systematic verification for the entire component testing phase.

*** CRITICAL AND MANDATORY *** - Before Completing Step 5, Go back to the Checklist and Make Sure all elements are marked [x], if not create Test Case for the Screen, Make Sure Each Design File has 1 Seperate Test Case and End to End Test Cases are not same as Component Test Cases, Hence there should be a Seperate Component Test Case for each Design File.

- Add the Generated Component Test Cases to the new .csv file under `#folder:output` with column headers as TC ID(for ex. TC-Comp-001), TC Title, TC Description, Prerequisite, Step No., Action, Expected Result.
- There should not be any mention of IDs(COPY-JCI..) in the Component Test Cases, it should be only Screen Element Name Make Sure to Follow the Guidelines Strictly.

*** NO SHORTCUTS, NO ASSUMPTIONS, NO EXCEPTIONS ***
