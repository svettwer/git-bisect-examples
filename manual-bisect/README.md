# manual-bisect
This file contains a basic reference of how to perform a manual git-bisect analysis to find bugs in your
software.

For a more detailed explanation of the workflow and some tips and tricks, please visit the article related to this
repository on [labs.consol.de](https://labs.consol.de/)

## Basic manual bisect reference
* Executing `git bisect` commands is only possible if your are in the root folder of your git repository
* Start a bisect operation: `git bisect start`
* Label a commit as okay: `git bisect good [<revision>]`
    * If no revision has been provided, the current revision is used. 
* Label a commit as broken: `git bisect bad [<revision>]`
    * If no revision has been provided, the current revision is used.
* Start a bisect operation and initialize the borders:
`git bisect start [<bad-revision> <good-revision>]`
* Abort the bisect operation: `git bisect reset`

For a complete reference of git bisect, please visit the 
[official web documentation](https://git-scm.com/docs/git-bisect) or use `man git bisect`.