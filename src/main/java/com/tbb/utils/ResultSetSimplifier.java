package com.tbb.utils;

/**
 * @author xebia
 * This code takes a database result set as input and converts it into a 2D array
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetSimplifier
{
  private ArrayList rsArray;
  private int i;
  private int nrArray;
  private int ncArray;

  public ResultSetSimplifier(ResultSet rs)
    throws SQLException
  {
    this.rsArray = new ArrayList();
    this.nrArray = 0;
    this.ncArray = 0;

    rs.last();
    this.nrArray = rs.getRow();
    this.ncArray = rs.getMetaData().getColumnCount();

    for (this.i = 1; this.i <= this.ncArray; this.i += 1) {
      rs.beforeFirst();

      while (rs.next())
        this.rsArray.add(rs.getString(this.i));
    }
  }

  public Object getElement(int row, int col)
  {
    int indx = row;
    if ((getRowCount() == 0) || (getColCount() == 0)) {
      System.err.println("Query did not return any rows!");
      return Integer.valueOf(-1);
    }if (indx > getRowCount() - 1) {
      System.err.println("Row index is out of bound! (larger than " + (getRowCount() - 1) + ")!");
      return Integer.valueOf(-1);
    }if (col > getColCount() - 1) {
      System.err.println("Column index is out of bound! (larger than " + (getColCount() - 1) + ")!");
      return Integer.valueOf(-1);
    }
    for (this.i = 0; this.i < col; this.i += 1) {
      indx += getRowCount();
    }
    return this.rsArray.get(indx);
  }

  public int getRowCount()
  {
    return this.rsArray == null ? 0 : this.nrArray;
  }

  public int getColCount() {
    return this.rsArray == null ? 0 : this.ncArray;
  }
}
