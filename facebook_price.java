import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Facebook Hackercup 2016 solution to problem "The Price is Correct"
 *
 * @author codemonkey3045 (Catia Goncalves)
 */
public class facebook_price {

  public static void main(String args[]) {

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int a = Integer.parseInt(br.readLine());

      for (int t = 1; t < a + 1; t++) {
        String[] l = br.readLine().trim().split("\\s+");
        int numbers = Integer.parseInt(l[0]);
        int price = Integer.parseInt(l[1]);

        String[] optionsRaw = br.readLine().trim().split("\\s+");
        int[] options = new int[numbers];
        System.out.println("here" + optionsRaw.length);
        for (int o = 0; o < optionsRaw.length; o++) {
          options[o] = Integer.parseInt(optionsRaw[o]);
          // options[o] = Integer.;
          // System.out.println(optionsRaw[o]);
        }

        int possibilities = solve(numbers, price, options);
        System.out.println("Case #" + t + ": " + possibilities);
      }
    } catch (IOException io) {
      io.printStackTrace();
    }
  }

  public static int sumRange(int[] arrayObj, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum = sum + arrayObj[i];
    }
    return sum;
  }

  public static int solve(int numbers, int price, int[] options) {
    int length = options.length;
    int numAnswers = 0;

    for (int a = 0; a < length; a++) {
      int start = a;
      if (start <= price) {
        for (int b = start; b < length; b++) {
          int end = b;
          int answer = sumRange(options, start, end);
          if (answer <= price) {
            numAnswers++;
          } else {
            break;
          }

        }
      }
    }
    return numAnswers;
  }
}


//TOO SLOW...in python! First attempt :( which sadly would take 30 minutes on worst case scenario to run

// __author__ = 'codemonkey3045'

// import math
// import datetime

// startTime = datetime.datetime.now()
// print startTime

// def solve(numbers, price, options):
//  length = len(options)
//  answers = 0

//  for a in range(0, length):
//    start = a
//    if start <= price:
//      for b in range(start, length):
//        end = b
//        # if end > start:
//          # do something
//        answer = sum(options[start:end+1])
//        # print "start %d end %d give sum %d" % (start, end, answer)
//        if answer <= price:
//          answers = answers + 1
//        else:
//          break

//  return answers


// T = int(raw_input())
// for t in range(1, T+1):
//  l = raw_input().split(' ')
//  numbers = int(l[0])
//  price = int(l[1])
//  options = raw_input().strip().split(' ')
//  # print options
//  options = [int(x) for x in options]
//  possibilities = solve(numbers, price, options)
//  print "Case #%d: %d" % (t, possibilities)

// endTime = datetime.datetime.now()
// diff = endTime - startTime
// print startTime
// print endTime
// print diff.seconds


