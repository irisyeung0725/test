/**
 * SQL commands
 * Including select/delete/update/insert
 */
package library.yangshijing.constant;
public abstract class SQLCommand
{
    //list all data in books table
    public static String QUERY_1 = "select stdID, stdFirstName from Student";
    //List the call numbers of books with the title ‘Database Management’
    public static String QUERY_2 = "select lbCallNum from LibBook where lbTitle = 'Database Management'";
    public static String QUERY_3 = "select lbTitle, bkAuthor from LibBook";
    public static String QUERY_4 = "select distinct bkPublication from LibBook";
    public static String QUERY_5 = "select lbCalNum from Checkout where bkIssuedate>'2013-08-01'";
    public static String QUERY_6 = "select lbTitle,bkAuthor from libBook where bkPublication='Wiley'";
    public static String QUERY_7 = "select SUM(coFine) from Checkout where coIsReturned='Y'";
    public static String RETURN_BOOK = "update CheckOut set coIsReturned=? where stdID=? and lbCallNum=?";
    public static String CHECK_BOOK = "insert into checkout(stdID,lbCallNum,coDueDate,coIsReturned) values(?,?,?,?)";
    //checkout summary
    public static String CHECKOUT_SUMMARY = "select strftime('%m',coDueDate) as month,count(*) as total from checkout where strftime('%Y',coDueDate)='2017' group by month order by total desc";
    public static String CHECKOUT_LIST = "select CheckOut.stdID, lbTitle,coDueDate,coIsReturned,coFine,stdFirstName from CheckOut,Student,LibBook where Student.stdID=Checkout.stdID and LibBook.lbCallNum=CheckOut.lbCallNum";




}


