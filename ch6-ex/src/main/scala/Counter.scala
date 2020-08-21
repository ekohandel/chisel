/*
 * This code is a minimal hardware described in Chisel.
 *
 * Blinking LED: the FPGA version of Hello World
 */

import chisel3._
import chisel3.util._

class Counter extends Module {
  val io = IO(new Bundle {
    val dec = Output(new SSDBundle())
    val pos = Output(Bool())
  })

  def Divider(cnt: Int) = {
    val countReg = RegInit(cnt.U(unsignedBitLength(cnt).W))
    val tick = Wire(Bool())

    tick := false.B
    when (countReg === 0.U) {
      countReg := cnt.U
      tick := true.B
    } .otherwise {
      countReg := countReg - 1.U;
    }

    tick
  }

  val countDivider = Divider(100000000)
  val countReg = RegInit(0.U(8.W))
  when (countDivider) {
    countReg := countReg + 1.U
  } 

  val displayMuxDivider = Divider(100000)
  val displayMuxReg = RegInit(0.U(1.W))
  when (displayMuxDivider) {
    displayMuxReg := displayMuxReg + 1.U
  }

  val off = Module(new SSD())
  off.io.enable := false.B
  off.io.digit := 0.U(4.W)

  val display0 = Module(new SSD())
  val display1 = Module(new SSD())
  display0.io.digit := countReg(3, 0)
  display0.io.enable := true.B
  display1.io.digit := countReg(7, 4)
  display1.io.enable := true.B

  io.pos := displayMuxReg
  io.dec := Mux(displayMuxReg(0), Mux(display1.io.digit === 0.U(4.W), off.io.dec, display1.io.dec), display0.io.dec)
}

/**
 * An object extending App to generate the Verilog code.
 */
object Exercise extends App {
  chisel3.Driver.execute(Array("--target-dir", "target"), () => new Counter())
}

