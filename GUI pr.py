import tkinter as tk

def click(btn_text):
    if btn_text == "=":
        try:
            result = str(eval(entry.get()))
            entry.delete(0, tk.END)
            entry.insert(tk.END, result)
        except:
            entry.delete(0, tk.END)
            entry.insert(tk.END, "Error")
    elif btn_text == "C":
        entry.delete(0, tk.END)
    else:
        entry.insert(tk.END, btn_text)

win = tk.Tk()
win.title("Calculator")

entry = tk.Entry(win, width=25, borderwidth=3, font=("Arial", 20))
entry.grid(row=0, column=0, columnspan=4, padx=10, pady=10)

buttons = [
    "7","8","9","/",
    "4","5","6","*",
    "1","2","3","-",
    "C","0","=","+"
]

row = 1
col = 0

for text in buttons:
    tk.Button(
        win, text=text, width=5, height=2,
        font=("Arial", 18),
        command=lambda t=text: click(t)
    ).grid(row=row, column=col)

    col += 1
    if col == 4:
        col = 0
        row += 1

win.mainloop()
