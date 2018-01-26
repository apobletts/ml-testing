/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__CWE182_Servlet_getParameter_Servlet_66a.java
Label Definition File: CWE80_XSS__CWE182_Servlet.label.xml
Template File: sources-sink-66a.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS (CWE 182: Collapse of Data into Unsafe Value)
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE80_XSS.s01;
import testcasesupport.*;

import javax.servlet.http.*;


public class CWE80_XSS__CWE182_Servlet_getParameter_Servlet_66a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* PRAETORIAN: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        String[] dataArray = new String[5];
        dataArray[2] = data;
        (new CWE80_XSS__CWE182_Servlet_getParameter_Servlet_66b()).badSink(dataArray , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        String[] dataArray = new String[5];
        dataArray[2] = data;
        (new CWE80_XSS__CWE182_Servlet_getParameter_Servlet_66b()).goodG2BSink(dataArray , request, response );
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

