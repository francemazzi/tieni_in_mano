#!/usr/bin/env sh
set -eu
gv=9.5.1
jv=25
b="${GRADLE_USER_HOME:-$HOME/.gradle}"
ok(){ command -v java >/dev/null 2>&1||return 1;n=$(java -version 2>&1|sed -n 's/.* version "\([0-9][0-9]*\).*/\1/p'|head -1);[ "${n:-0}" -ge "$jv" ]; }
if ! ok;then a=$(uname -m);[ "$a" = arm64 ]&&a=aarch64||a=x64;o=$(uname -s|tr A-Z a-z);[ "$o" = darwin ]&&o=mac;jd="$b/jdks/temurin-$jv-$o-$a";jh="$jd";[ "$o" = mac ]&&jh="$jd/Contents/Home";tmp="$jd.tmp";if [ ! -x "$jh/bin/java" ];then rm -rf "$tmp";mkdir -p "$tmp";curl -LfsS "https://api.adoptium.net/v3/binary/latest/$jv/ga/$o/$a/jdk/hotspot/normal/eclipse" -o "$jd.tgz";tar -xzf "$jd.tgz" -C "$tmp" --strip-components=1;rm -rf "$jd";mv "$tmp" "$jd";fi;export JAVA_HOME="$jh";export PATH="$JAVA_HOME/bin:$PATH";fi
d="$b/wrapper/dists/gradle-$gv-bin"
z="$d.zip"
g="$d/gradle-$gv/bin/gradle"
[ -x "$g" ]||{ mkdir -p "$d";curl -fsSL "https://services.gradle.org/distributions/gradle-$gv-bin.zip" -o "$z";unzip -q "$z" -d "$d"; }
exec "$g" "$@"
