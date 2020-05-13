clear;
figure_num = 1;

% Define the frequency of the sample rate in Hz
sampleRate = 256;

% Define f as a vector from 0 Hz to one-half the sample rate
f = linspace(0,sampleRate/2,sampleRate);

% Convert linear frequency to angular frequency
% omega, units = radians/second
w = 2*pi*f;

% Convert angular frequency to Discrete Frequency
Omega = w / 256;

% Define the term s, where real term (sigma) equals 0
% 1j is used for performance in MATLAB
s = 1j*Omega;

% Creating the z-term in the transfer function
n = 1;
zN = z(s,n);

% Constants in the given transfer function
b0 = 0.125;
a1 = 0.875;

% Given Transfer Function
H = b0./(1-a1.*zN);

% Plot the magnitude response of the transfer function in dB versus
% Discrete Frequency with a logarithmic scale on the x-axis
figure(figure_num); figure_num = figure_num + 1;
semilogx(Omega,20*log10(abs(H)));
hold on

hold off
xlabel('Discrete Frequency, Omega (Radians/Sample)')
ylabel('Magnitude (dB)')
xlim([0 pi])
ylim([-25 2])
grid on

% Function to create z^n term
function z = z(s,n)
    z = exp(-s*n);
end