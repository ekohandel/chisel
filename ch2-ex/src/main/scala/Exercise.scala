/*
 * This code is a minimal hardware described in Chisel.
 *
 * Blinking LED: the FPGA version of Hello World
 */

import chisel3._
import chisel3.Driver

/**
 * The blinking LED component.
 */

class Exercise extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(2.W))
    val led = Output(UInt(1.W))
  })

  io.led := io.sw(0)
}

/**
 * An object extending App to generate the Verilog code.
 */
object Exercise extends App {
  chisel3.Driver.execute(Array("--target-dir", "target"), () => new Exercise())
}
