## Clock signal
set_property -dict { PACKAGE_PIN E3    IOSTANDARD LVCMOS33 } [get_ports { clock }];
create_clock -add -name sys_clk_pin -period 10.00 -waveform {0 5} [get_ports { clock }];

## LEDs
set_property -dict { PACKAGE_PIN H5    IOSTANDARD LVCMOS33 } [get_ports { io_led }]; #IO_L24N_T3_35 Sch=led[4]

## Buttons
set_property -dict { PACKAGE_PIN D9    IOSTANDARD LVCMOS33 } [get_ports { reset }]; #IO_L6N_T0_VREF_16 Sch=btn[0]
