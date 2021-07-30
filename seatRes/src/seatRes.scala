//book seat
//show available seats according to destination

import seatRes.seatarr

import scala.io.StdIn.readInt
import scala.language.postfixOps

object seatRes extends App {

  val seatarr= Array.ofDim[Int](4, 5);
  val destination1= Array.ofDim[Int](4, 5);
  val destination2= Array.ofDim[Int](4, 5);
  val countries = Array("SriLanka","India","China","Japan");
  var isWhile = true;

  while (isWhile){
    var check=0;
    println("1:To book a seat\n2:To check availability\n3:To exit\n");
    print("Enter a Number:")
    check=readInt();
    check match{
      case 1 => bookseat();
      case 2 => checkseat();
      case 3 => isWhile = false
      case _ => println("Enter valid number")
    }

  }

  def bookseat(): Unit ={
    var bs=true;
    var rn=0;
    var cn=0;
    while (bs){
      println("Enter the row Number:");
      rn=readInt();
      println("Enter the column Number:");
      cn=readInt();
      if(seatarr.length>rn && seatarr(0).length>cn)
        book(rn, cn);
      else {
        var ec = 0;
        println("Enter valid row number and column number!");
        println("1:Try again\nAny Number To Exit");
        println("Enter Number:")
        ec = readInt();
        ec match {
          case 1 =>
          case _ => bs=false;
        }
      }
      bs=false;
    }
  }

  def book(rn: Int, cn: Int): Unit ={
    if (seatarr(rn)(cn)==0){
      var i=0;
      println("--Choose the destinations--");
      for ( c<- countries){
        println("Enter "+i+" To:"+c);
        i=i+1;
      }
      var fc=0;
      var tc=0;
      var tb=true; // just for the condition of the following while loop
      while (tb){
        println("From:");
        fc=readInt();
        println("To:");
        tc=readInt();
        if((fc<countries.length && tc<countries.length) && fc<tc)tb=false;
        else println("Please enter valid country codes!\n");
      }
      seatarr(rn)(cn)=1;
      destination1(rn)(cn)=fc;
      destination2(rn)(cn)=tc;
      println("Seat successfully booked from "+countries(fc)+" To "+countries(tc));
    }
    else println("Seat already booked");
  }

  def checkseat() :Unit={
    var rnf=0;
    var cnf=0;
    println("---Available seats---\n");
    for(rnf <- 0 until seatarr.length){
      for (cnf <- 0 until  seatarr(0).length){
        println("Seat Number:"+rnf+"/"+cnf+"\n---Availablility---");
          if (destination1(rnf)(cnf)==0 && destination2(rnf)(cnf)==0){
            println("From:"+countries(0)+"\nTo:"+countries(3));
          }else if (destination1(rnf)(cnf)!=0){
            println("From:"+countries(0)+"\nTo:"+countries(destination2(rnf)(cnf))+"\n");
            if (destination2(rnf)(cnf)!=3){
              println("From:"+countries(destination2(rnf)(cnf))+"\nTo:"+countries(3));
            }
          }else if (destination2(rnf)(cnf)!=3) {
            println("From:" + countries(destination2(rnf)(cnf)) + "\nTo:" + countries(3));
          }else println("Not Available");
        println("\n");
      }

    }
  }




}
