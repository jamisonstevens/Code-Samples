clear;

syms n T t A tau;
f0 = 1/T;

fx = A - A * t / tau;

x0 = (1/T)*int(fx,t,0,tau)
xn = (1/T)*int(fx*exp(-1j*2*pi*n*f0*t),t,0,tau)