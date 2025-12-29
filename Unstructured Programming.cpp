// Unstructured Programming assignment
// By Brenden Harris





//If condtion//

IF_END:
if (!(condition)) goto IF_END2;

// ----- body -----

IF_END2:;


//If else //
if (!(condition)) goto ELSE_PART;

// ----- then-body -----
goto IF_END;

ELSE_PART:
// ----- else-body -----

IF_END:;

// while //

WHILE_START:

if (!(condition)) goto WHILE_END;

// ----- loop body -----

goto WHILE_START;

WHILE_END:;

// do while //

DO_START:

// ----- body -----

if (condition) goto DO_START;


