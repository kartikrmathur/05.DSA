# DSA Project - Module Cleanup Script
# Run with IntelliJ CLOSED. Then reopen and do File, Invalidate Caches, Restart.

$projectRoot = "E:\01.SelfBuilding_Technical\05.DSA"

Write-Host "Step 1: Fixing modules.xml" -ForegroundColor Cyan

$xml  = '<?xml version="1.0" encoding="UTF-8"?>' + "`n"
$xml += '<project version="4">' + "`n"
$xml += '  <component name="ProjectModuleManager">' + "`n"
$xml += '    <modules>' + "`n"
$xml += '      <module fileurl="file://$PROJECT_DIR$/05. DSA.iml" filepath="$PROJECT_DIR$/05. DSA.iml" />' + "`n"
$xml += '    </modules>' + "`n"
$xml += '  </component>' + "`n"
$xml += '</project>'

Set-Content -Path "$projectRoot\.idea\modules.xml" -Value $xml -Encoding UTF8
Write-Host "modules.xml fixed - now has 1 module only" -ForegroundColor Green

Write-Host "Step 2: Deleting stray .iml files" -ForegroundColor Cyan

$strayImls = Get-ChildItem -Path $projectRoot -Filter "*.iml" -Recurse |
             Where-Object { $_.FullName -ne "$projectRoot\05. DSA.iml" }

if ($strayImls.Count -eq 0) {
    Write-Host "No stray .iml files found." -ForegroundColor Green
} else {
    foreach ($file in $strayImls) {
        Remove-Item $file.FullName -Force
        Write-Host "Deleted: $($file.Name)" -ForegroundColor Yellow
    }
    Write-Host "Deleted $($strayImls.Count) stray .iml files" -ForegroundColor Green
}

Write-Host "Done! Now open IntelliJ and invalidate caches." -ForegroundColor Cyan
