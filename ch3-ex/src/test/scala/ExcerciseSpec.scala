/*
 * This code is a test for a mux
 */

import chisel3._
import chisel3.iotesters.PeekPokeTester
import org.scalatest._

class ExerciseTester(dut: Exercise) extends
  PeekPokeTester(dut) {
    poke(dut.io.sw, 0.U)
    expect(dut.io.led, 0.U)

    step(1)

    poke(dut.io.sw, 1.U)
    expect(dut.io.led, 0.U)

    step(1)

    poke(dut.io.sw, 2.U)
    expect(dut.io.led, 0.U)

    step(1)

    poke(dut.io.sw, 3.U)
    expect(dut.io.led, 1.U)

    step(1)

    poke(dut.io.sw, 4.U)
    expect(dut.io.led, 1.U)

    step(1)

    poke(dut.io.sw, 5.U)
    expect(dut.io.led, 0.U)

    step(1)

    poke(dut.io.sw, 6.U)
    expect(dut.io.led, 1.U)

    step(1)

    poke(dut.io.sw, 7.U)
    expect(dut.io.led, 1.U)

    step(1)
}

class ExcerciseWaveformSpec extends FlatSpec with Matchers {
  "Waveform" should "pass" in {
    chisel3.iotesters.Driver.execute(Array("--generate-vcd-output", "on", "--target-dir", "target"), () =>
        new Exercise()) { c =>
      new ExerciseTester(c)
    } should be (true)
  }
}
