syms t s
V_1 = cos(2000*pi*t);
V_1_s = laplace(V_1);
func = V_1_s * 1/(0.0016*s + 1);
ilaplace(func)