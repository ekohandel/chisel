import chisel3.iotesters.PeekPokeTester
import org.scalatest._

class ExerciseSpec extends FlatSpec with Matchers {
  "Hello" should "pass" in {
    chisel3.iotesters.Driver.execute(Array("--target-dir", "target"), () => new Exercise()) { c =>
      new PeekPokeTester(c) {

        println("Start the blinking LED")
        for (i <- 0 until 100) {
          step(10000)
          val ch = if (peek(c.io.led) == 0) 'o' else '*'
          printf(ch + "\r")
        }
        println("\nEnd the blinking LED")
      }
    } should be (true)
  }
}
