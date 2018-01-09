# automated-bisect
This file contains a basic reference of how to perform a automated git-bisect analysis to find bugs in your
software.

For a more detailed explanation of the workflow and some tips and tricks, please visit the article related to this
repository on [labs.consol.de](https://labs.consol.de/)

## Basic automated bisect reference
* It's required to initialize the git bisect operation, before you're able to start the test script:
 `git bisect start <bad-revision> <good-revision>` 
* It's possible to pass commands to git bisect to automatically execute a test procedure: `git bisect run`
 
## Example of automated bisect using the cake-factory
```bash
git bisect start broken stable
git bisect run sh automated-bisect/findBug.sh
```