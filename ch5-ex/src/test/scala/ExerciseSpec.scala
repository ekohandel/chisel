import chisel3.iotesters.PeekPokeTester
import org.scalatest._
import chisel3._

class ExerciseSpec extends FlatSpec with Matchers {
  "Hello" should "pass" in {
    chisel3.iotesters.Driver.execute(Array("--target-dir", "target"), () => new Exercise()) { c =>
      new PeekPokeTester(c) {
        poke(c.io.digit, "b0000".U)
        expect(c.io.dec.a, true.B)
        expect(c.io.dec.b, true.B)
        expect(c.io.dec.c, true.B)
        expect(c.io.dec.d, true.B)
        expect(c.io.dec.e, true.B)
        expect(c.io.dec.f, true.B)
        expect(c.io.dec.g, false.B)

        step(1)

        poke(c.io.digit, "b0001".U)
        expect(c.io.dec.a, false.B)
        expect(c.io.dec.b, true.B)
        expect(c.io.dec.c, true.B)
        expect(c.io.dec.d, false.B)
        expect(c.io.dec.e, false.B)
        expect(c.io.dec.f, false.B)
        expect(c.io.dec.g, false.B)

        step(1)
      }
    } should be (true)
  }
}
