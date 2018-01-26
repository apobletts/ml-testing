import sys
import os
import re

def annotate(filename, outfile):
    out = ""
    with open(filename, "r") as f:
        # split on lines
        lines = f.read().split("\n")
        # flags
        badFunctionFound = False
        # for each line, if you see a function name
        for line in lines:
            if re.search("(public|private).*(bad|badSource|badSink)\(", line) != None:
                badFunctionFound = True
            elif re.search("(public|private).*good", line) != None:
                badFunctionFound = False
            elif badFunctionFound:
                # check for potential flaw
                line = line.replace("POTENTIAL FLAW", "PRAETORIAN")
            out += line + "\n"
    with open(outfile, "w") as f:
        f.write(out)

def annotate_dir(directory, outdir):
    for f in os.listdir(directory):
        annotate(os.path.join(directory, f), os.path.join(outdir, f))


if __name__=='__main__':
    if sys.argv < 3:
        print("Usage: python help_annotate.py directory output_directory")

    directory = sys.argv[1]
    output_dir = sys.argv[2]
    num = annotate_dir(directory, output_dir)
    print("Annotated files: ", str(num))
