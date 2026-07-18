import re
from pathlib import Path

text = Path(r"C:\Users\rjatc\Downloads\assessment1.txt").read_text(encoding="utf-8")
lines = []
pattern = re.compile(
    r'insert\s+into country\s*\(\s*co_code\s*,\s*co_name\s*\)\s*values\s*\("([^"]+)",\s*"([^"]+)"\)',
    re.IGNORECASE,
)
for match in pattern.finditer(text):
    code = match.group(1)
    name = match.group(2).replace("'", "''")
    lines.append(f"INSERT INTO country (co_code, co_name) VALUES ('{code}', '{name}');")

out = Path(__file__).resolve().parents[1] / "src/main/resources/data/country-data.sql"
out.parent.mkdir(parents=True, exist_ok=True)
out.write_text("DELETE FROM country;\n" + "\n".join(lines) + "\n", encoding="utf-8")
print(f"Wrote {len(lines)} country rows to {out}")
